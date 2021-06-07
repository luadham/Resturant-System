package com.resturant.controller;

import javafx.scene.control.*;

/**
 * The type Input control to Control Inputs
 *
 * @author Adham Adel
 */
public class InputValidationController {
    /**
     * Verify text field.
     *
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
     * Verify int number boolean.
     *
     * @param textFields the text fields
     * @return the boolean
     */
    public static boolean verifyIntNumber(TextField... textFields) {
        for (TextField textField : textFields) {
            try {
                Integer.parseInt(textField.getText());
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
     *
     * @param label the label
     */
    public static void clearErrorMessage(Label label) {
        label.setText("");
    }

    /**
     * Clear fields.
     *
     * @param textFields the text fields
     */
    public static void clearFields(TextInputControl... textFields) {
        for (TextInputControl textField : textFields) {
            textField.setText("");
        }
    }

    /**
     * Is checked boolean.
     *
     * @param radioButtons the radio buttons
     * @return the boolean
     */
    public static boolean isChecked(RadioButton... radioButtons) {
        for (RadioButton radioButton : radioButtons) {
            if (radioButton.isSelected())
                return true;
        }
        return false;
    }

    /**
     * Verify combo box boolean.
     *
     * @param comboBoxes the combo boxes
     * @return the boolean
     */
    /**
     * Verify combo box boolean.
     *
     * @param comboBoxes the combo boxes
     * @return the boolean
     */
    public static boolean verifyComboBox(ComboBox<String>... comboBoxes) {
        for (ComboBox<String> comboBox : comboBoxes) {
            if (comboBox.getValue().equals(""))
                return false;
        }
        return true;
    }

    public static boolean verifyintComboBox(ComboBox<Integer> comboBoxes) {
        return !comboBoxes.getValue().equals("");
    }

}
