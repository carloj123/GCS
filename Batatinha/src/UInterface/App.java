/*package UInterface;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Business.Milhas;
import Persistence.Bar;
import Persistence.Cliente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class App extends Application{

    private Bar bar;
    private Milhas milhas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        setup();

        TextInputDialog dialogInput = new TextInputDialog();

        GridPane buttonsPane = new GridPane();

        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setHgap(50);
        buttonsPane.setVgap(30);
        buttonsPane.setPadding(new Insets(10, 10, 10, 10));



        //CADASTRAR CLIENTE NO BAR
        Text info = new Text("Se o cliente nao for socio, nao informar nenhum numero");
        TextField cpf = new TextField();
        TextField nome = new TextField();
        TextField genero = new TextField();
        TextField idade = new TextField();
        TextField numSocio = new TextField();

        Button cadastrarCliente = new Button("salvar");
        cadastrarCliente.setOnAction(e->{
            Cliente c = new Cliente(nome.toString(), cpf.toString(), Integer.parseInt(idade.toString()), genero.toString().charAt(0));
            bar.add(cpf.toString(), c);
        });

        Button entrouCliente = new Button("Novo Cliente");
        entrouCliente.setOnAction(e->{
            dialogInput.setTitle("Registrar novo cliente");
            dialogInput.setHeaderText("Insira as informacoes necessarias");
            dialogInput.getDialogPane().getChildren().get(1).setVisible(false);
            dialogInput.getDialogPane().getChildren().get(2).setVisible(false);

            GridPane contents = new GridPane();

            contents.add(info, 0 , 0);
            contents.add(cpf, 1, 0);
            contents.add(nome, 2, 0);
            contents.add(genero, 3, 0);
            contents.add(numSocio, 4, 0);
            contents.add(cadastrarCliente, 5,0);

            dialogInput.getDialogPane().setContent(contents);
            dialogInput.showAndWait();

        });
        
        
        //REMOVER CLIENTE DO BAR        
        TextField cpfRetirar = new TextField("CPF do cliente");
        
        Button removerCliente = new Button("salvar");
        removerCliente.setOnAction(e->{
        	bar.saiuDoBar(cpf.toString());
        });
        
        Button saiuCliente = new Button("Remover cliente");
        
        saiuCliente.setOnAction(e->{
            dialogInput.setTitle("Remover cliente");
            dialogInput.setHeaderText("Insira as informacoes necessarias");
            dialogInput.getDialogPane().getChildren().get(1).setVisible(false);
            dialogInput.getDialogPane().getChildren().get(2).setVisible(false);

            GridPane contents = new GridPane();

            contents.add(cpfRetirar, 0 , 0);
            contents.add(removerCliente, 1, 0);

            dialogInput.getDialogPane().setContent(contents);
            dialogInput.showAndWait();
        });
        
        //MOSTRAR OS CLIENTES DO DIA
        TextField path = new TextField("Diretorio que deseja salvar");
        
        Button escreverClientes = new Button();
        
        escreverClientes.setOnAction(e->{
        	try {
				bar.escreveArquivo(path.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });
        
        Button mostrarClientes = new Button("salvar");
        
        mostrarClientes.setOnAction(e->{
        	
            dialogInput.setTitle("Salvar clientes em txt");
            dialogInput.setHeaderText("Insira as informacoes necessarias");
            dialogInput.getDialogPane().getChildren().get(1).setVisible(false);
            dialogInput.getDialogPane().getChildren().get(2).setVisible(false);

            GridPane contents = new GridPane();

            contents.add(path, 0 , 0);
            contents.add(escreverClientes, 1, 0);

            dialogInput.getDialogPane().setContent(contents);
            dialogInput.showAndWait();
        	
        });
        
        
        //MOSTRA CLIENTES NO BAR
        
        
        //MOSTRA UM CLIENTE DE CERTO CPF SE ESTÁ NO BAR
        
        
        //QUANTAS PESSOAS ESTÃO NO BAR
        
        
        //DISTRIBUIÇÃO DE GÊNERO DAS PESSOAS NO BAR
        
        
        //QUANTOS SAO SOCIOS E QUANTOS NAO SAO QUE ESTAO NO BAR
        

        BorderPane pane = new BorderPane();
        pane.setCenter(buttonsPane);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("\r\r\rBB\n Batatas Bar");
        primaryStage.show();

    }

    private void setup(){
        bar = new Bar();
        milhas = new Milhas();
    }
}
*/
