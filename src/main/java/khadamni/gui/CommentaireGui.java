package khadamni.gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import khadamni.modeles.Commentaire;
import khadamni.modeles.Role;
import khadamni.modeles.User;
import khadamni.utiles.Connection;

public class CommentaireGui {

    public static int createCommentaire(java.sql.Connection connection, Commentaire commentaire) {
        if (connection == null) {
            System.err.println("Connection is null");
            return -1;
        }

        String sql = "INSERT INTO commentaire (content, date, userId) VALUES ('" +
                commentaire.getContent() + "', '" +
                new java.sql.Date(commentaire.getDate().getTime()) + "', " +
                commentaire.getUserId() + ")";

        try (Statement stmt = connection.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (rowsAffected > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }



    /*public static List<Commentaire> getAllCommentairesForUser(Connection connection, User user) {
        List<Commentaire> commentaireaires = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM commentaireaire WHERE userId = ?")) {

            preparedStatement.setInt(1, user.getIdUser());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int commentaireaireId = resultSet.getInt("commentaireaireId");
                    String content = resultSet.getString("content");
                    Date date = resultSet.getDate("date");

                    Commentaire commentaireaire = new Commentaire(commentaireaireId, content, date, user.getIdUser());
                    commentaireaires.add(commentaireaire);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaireaires;
    }

    public static boolean updateCommentaire(Connection connection, Commentaire commentaireaire) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE commentaireaire SET content = ?, date = ? WHERE commentaireaireId = ?")) {

            preparedStatement.setString(1, commentaireaire.getContent());
            preparedStatement.setDate(2, new java.sql.Date(commentaireaire.getDate().getTime()));
            preparedStatement.setInt(3, commentaireaire.getCommentaireId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCommentaire(Connection connection, int commentaireaireId) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM commentaireaire WHERE commentaireaireId = ?")) {

            preparedStatement.setInt(1, commentaireaireId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
