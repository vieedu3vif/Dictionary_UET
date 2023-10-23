package screen;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import dictionary.tool.TranslateAPI;

public class Translate implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StringBuffer text = new StringBuffer();

        translate.textProperty().addListener((observable, oldValue, newText) -> {
            text.setLength(0); // Xóa nội dung cũ của StringBuffer
            text.append(newText); // Thêm nội dung mới từ TextArea vào StringBuffer
            // Dịch và Cập nhật nội dung của cái vừa nhập
            try {
                translateDetail.setText(TranslateAPI.translate("en","vi",text.toString()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });

        logout.setOnMouseEntered(event -> {
            logout.setScaleX(1.2);
            logout.setScaleY(1.2);
        });

        logout.setOnMouseExited(event -> {
            logout.setScaleX(1.0);
            logout.setScaleY(1.0);
        });

        logout.setOnAction(e -> {
            Logout();
            System.out.println("Haha");
        }) ;

    }


    @FXML
    private void Logout() {
        show("/com/example/dictionary_uet/Main.fxml");
    }

    private void setNode(Node node) {
        screen.getChildren().clear();
        screen.getChildren().add(node);
    }

    @FXML
    private void show(String path) {
        try {
            AnchorPane component = FXMLLoader.load(getClass().getResource(path));
            setNode(component);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button logout,volume1,volume2;


    @FXML
    private TextArea translate,translateDetail;

    @FXML
    private  AnchorPane screen;

    @FXML
    private Tooltip Logout;

}
