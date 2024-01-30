package khadamni.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import khadamni.modeles.Publication;
import khadamni.modeles.User;


public class PublicationGui {

    // Create a new Publication
    public static int createPublication(Connection connection, Publication publication) {
        // Check if the provided connection is not null
        if (connection == null) {
            System.err.println("Connection is null");
            return -1;
        }

        String sql = "INSERT INTO publication (title, content, date, clientId, freelancerId) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, publication.getTitle());
            preparedStatement.setString(2, publication.getContent());
            preparedStatement.setDate(3, new java.sql.Date(publication.getDate().getTime()));
            preparedStatement.setInt(4, publication.getclientId());
            preparedStatement.setInt(5, publication.getFreelancerId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Return -1 if the insertion fails
    }

    // Retrieve all Publications for a given client
    public static List<Publication> getAllPublicationsForClient(Connection connection, User client) {
        List<Publication> publications = new ArrayList<>();
        String sql = "SELECT * FROM publication WHERE clientId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, client.getIdUser());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int publicationId = resultSet.getInt("publicationId");
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    Date date = resultSet.getDate("date");

                    Publication publication = new Publication(publicationId, title, content, date, client.getIdUser(), 1);
                    publications.add(publication);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publications;
    }

    // Update an existing Publication
    public static boolean updatePublication(Connection connection, Publication publication) {
        String sql = "UPDATE publication SET title = ?, content = ?, date = ? WHERE publicationId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, publication.getTitle());
            preparedStatement.setString(2, publication.getContent());
            preparedStatement.setDate(3, new java.sql.Date(publication.getDate().getTime()));
            preparedStatement.setInt(4, publication.getPublicationId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a Publication
    public static boolean deletePublication(Connection connection, int publicationId) {
        String sql = "DELETE FROM publication WHERE publicationId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, publicationId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
