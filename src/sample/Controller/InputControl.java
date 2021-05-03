package sample.Controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

/**
 * The type Input control to Control Inputs
 * @author Adham Adel
 */
public class InputControl {
    /**
     * Verify text field.
     * @param textFields the text fields
     * @return true if TextField is not empty
     */
    public static boolean verifyTextField(TextInputControl... textFields) {
        for (TextInputControl textField : textFields) {
            if (textField.getText().equals(""))
                return false;
        }
        return true;
    }

    /**
     * Verify double number.
     *
     * @param textFields the text fields
     * @return true if Text is Number
     */
    public static boolean verifyDoubleNumber(TextField... textFields) {
        for (TextField textField : textFields) {
            try {
                Double.parseDouble(textField.getText());
            } catch (NumberFormatException exception) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets error message.
     *
     * @param label        the label
     * @param errorMessage the error message
     */
    public static void setErrorMessage(Label label, String errorMessage) {
        label.setText(errorMessage);
    }

    /**
     * Remove error message.
     * @param label the label
     */
    public static void removeErrorMessage(Label label) {
        label.setText("");
    }

    public static void clearFields(TextInputControl... textFields) {
        for (TextInputControl textField : textFields) {
            textField.setText("");
        }
    }
}
