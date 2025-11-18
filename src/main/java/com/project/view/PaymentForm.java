package com.project.view;

import com.project.controller.ReservationController;

import com.project.dao.PaymentDetails;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentForm {

    private ReservationController controller = new ReservationController();

    public Scene getScene(Stage stage,
                          int clientId,
                          int eventId,
                          int categoryId,
                          int quantity) {

        Label title = new Label("Payment Information");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Nom sur la carte");

        TextField cardField = new TextField();
        cardField.setPromptText("Numéro de carte (16 chiffres)");

        Button payBtn = new Button("Payer");

        payBtn.setOnAction(e -> {
            try {
                PaymentDetails details = new PaymentDetails(
                        nameField.getText(),
                        cardField.getText()
                );

                controller.processPaymentAndReservation(
                        clientId, eventId, categoryId, quantity, details
                );

                showSuccess("Paiement réussi ! Réservation confirmée.");
                stage.close();

            } catch (Exception ex) {
                showError(ex.getMessage());
            }
        });

        VBox root = new VBox(15, title, nameField, cardField, payBtn);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        return new Scene(root, 400, 350);
    }

    private void showSuccess(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).showAndWait();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).showAndWait();
    }
}
