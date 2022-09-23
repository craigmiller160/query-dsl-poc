package db.migration;

import com.github.javafaker.Faker;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V1_02__Generate_Records extends BaseJavaMigration {
  private static final String SELECT_POSITIONS =
      """
            SELECT *
            FROM positions
            """;
  private static final String INSERT_EMPLOYEE =
      """
                  INSERT INTO employees(id, first_name, last_name, date_of_birth, position_id)
                  VALUES (:id, :firstName, :lastName, :dateOfBirth, :positionId)
              """;

  private static final String INSERT_TEAM =
      """
                INSERT INTO teams (id, supervisor_id)
                VALUES (:id, :supervisorId)
            """;

  private static final String INSERT_TEAM_MEMBER =
      """
                INSERT INTO team_members (id, team_id, employee_id)
                VALUES (:id, :teamId, :employeeId)
            """;

  private final Faker faker = new Faker();

  @Override
  public void migrate(final Context context) throws Exception {
    final var jdbcTemplate =
        new NamedParameterJdbcTemplate(
            new SingleConnectionDataSource(context.getConnection(), true));
    final var positions = getPositions(jdbcTemplate);
    IntStream.range(0, 5).forEach(index -> createTeam(jdbcTemplate, positions));
  }

  private UUID createTeam(
      final NamedParameterJdbcTemplate jdbcTemplate, final Positions positions) {
    final var supervisorId = createEmployee(jdbcTemplate, positions, true);
    final var teamId = UUID.randomUUID();
    final var params =
        new MapSqlParameterSource().addValue("id", teamId).addValue("supervisorId", supervisorId);
    jdbcTemplate.update(INSERT_TEAM, params);
    IntStream.range(0, 10).forEach(index -> createTeamMember(jdbcTemplate, positions, teamId));
    return teamId;
  }

  private UUID createTeamMember(
      final NamedParameterJdbcTemplate jdbcTemplate, final Positions positions, final UUID teamId) {
    final var id = UUID.randomUUID();
    final var employeeId = createEmployee(jdbcTemplate, positions, false);
    final var params =
        new MapSqlParameterSource()
            .addValue("id", id)
            .addValue("teamId", teamId)
            .addValue("employeeId", employeeId);
    jdbcTemplate.update(INSERT_TEAM_MEMBER, params);
    return id;
  }

  private UUID createEmployee(
      final NamedParameterJdbcTemplate jdbcTemplate,
      final Positions positions,
      final boolean isSupervisor) {
    final var id = UUID.randomUUID();
    final UUID positionId;
    if (isSupervisor) {
      positionId = positions.supervisorId();
    } else {
      positionId = positions.workerId();
    }
    final var params =
        new MapSqlParameterSource()
            .addValue("id", id)
            .addValue("firstName", faker.name().firstName())
            .addValue("lastName", faker.name().lastName())
            .addValue("positionId", positionId)
            .addValue(
                "dateOfBirth",
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

    jdbcTemplate.update(INSERT_EMPLOYEE, params);
    return id;
  }

  private Positions getPositions(final NamedParameterJdbcTemplate jdbcTemplate) {
    return jdbcTemplate
        .queryForStream(
            SELECT_POSITIONS,
            new MapSqlParameterSource(),
            (rs, i) -> {
              final var id = UUID.fromString(rs.getString("id"));
              if (Objects.equals(rs.getString("name"), "Supervisor")) {
                return new Positions(id, null);
              }
              return new Positions(null, id);
            })
        .reduce(
            (acc, positions) ->
                new Positions(
                    Optional.ofNullable(acc.supervisorId()).orElse(positions.supervisorId()),
                    Optional.ofNullable(acc.workerId()).orElse(positions.workerId())))
        .orElseThrow();
  }

  private record Positions(UUID supervisorId, UUID workerId) {}
}
