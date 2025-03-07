package Group25;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import javafx.application.Platform;

import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import org.mindrot.jbcrypt.BCrypt;


public class Group25 extends Application {
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Global declarations for labels, text fields, and buttons
    private Label lblHospSignupHospitalCode;
    private Label lblHospSignupFirstName;
    private Label lblHospSignupLastName;
    private Label lblHospSignupEmail;
    private Label lblHospSignupContactNumber;
    private Label lblHospSignupCertifiedId;
    private Label lblHospSignupPasssword1;
    private Label lblHospSignupPasssword2;
    

    private TextField txtFieldHospSignupHospitalCode;
    private TextField txtFieldHospSignupFirstName;
    private TextField txtFieldHospSignupLastName;
    private TextField txtFieldHospSignupEmail;
    private TextField txtFieldHospSignupContactNumber;
    private TextField txtFieldHospSignupCertifiedId;
    private PasswordField HospSignupPassword1;
    private PasswordField HospSignupPassword2;

    private Button btnHospSignup;
    private Button signup_page_btnHome;
    Label lbl_nameOfHospital,lbl_hospitalCode,lbl_location,lbl_contactNumber,lbl_email;
    Label lbl_central_login_ID,lbl_central_login_pas;
    Label lbl_hospSearch_hospName,lbl_hospSearch_hospName_value,
            lbl_hospSearch_hospCode,lbl_hospSearch_hospCode_value,
            lbl_hospSearch_location,lbl_hospSearch_location_value,
            lbl_hospSearch_contact,lbl_hospSearch_contact_value,
            lbl_hospSearch_email,lbl_hospSearch_email_value,
            lbl_hospSearch_regDate,lbl_hospSearch_regDate_value;
    
    
    Label   lbl_patientFirstName, lbl_patientFirstName_value,
            lbl_patientLastName, lbl_patientLastName_value,      
            lbl_patientSearch_location, lbl_patientSearch_location_value,
            lbl_patientSearch_contact, lbl_patientSearch_contact_value,
            lbl_patientSearch_email, lbl_patientSearch_email_value,
            lbl_patientSearch_regDate, lbl_patientSearch_regDate_value,
            lbl_patient_gender,lbl_patient_gender_value,
            lbl_patient_nationalId,lbl_patient_nationalId_value;
            
    
    Label lbl_hosp_login_pas,lbl_hosp_login_ID;

    
    ToggleGroup hsp_group;
    RadioButton hsp_byName;
    RadioButton hsp_byId;
    Button btn_search_hosp = new Button("SEARCH");
    ToggleGroup patient_group;
    ToggleGroup staff_group;
    RadioButton byId;
    RadioButton byName;
    
    RadioButton DOCTOR,NURSE;
    Button btn_search_patient;
   
    
    Button register;
    Button btn_central_login;
    Button btn_reg_hosp,btn_view_reg_hosp,btn_view_reg_patients,btn_home1,btn_home2,btn_home3;
    Button HDMS,HOSPITAL;
    Button home_main;
    Button btn_hosp_signin_SigninAndSignupPage,btn_hosp_signup_SigninAndSignupPage;
    Button btn_hosp_login,btn_hosp_signup_home1,btn_hosp_signin_home2;
    Button btn_hosp_reg_patients,btn_hosp_upload_records,btn_hosp_retrieve_records;
    Button SIGNOUT_HOSPITALS,SIGNOUT_HDMS;
    Button signout;
    
    
    TextField txt_field_nameOfHospital,
            txt_field_hospitalCode,
            txt_field_location,
            txt_field_contactNumber,
            txt_field_email;
    TextField txt_field_central_login_ID;
    PasswordField txt_field_central_login_pas;
    TextField txt_field_patientSearch;
    TextField txt_field_hospSearch;
    TextField txt_field_hosp_login_pas,txt_field_hosp_login_ID;

    @Override
    public void start(Stage primaryStage) {
    //HOSPITL REGISTERATION PAGE
    lbl_nameOfHospital = new Label("Name of Hospital");
    lbl_hospitalCode= new Label("Hospital Code");
    lbl_location= new Label("Location");
    lbl_contactNumber = new Label("Contact Number");
    lbl_email= new Label("Email");       
    txt_field_nameOfHospital=new TextField();
    txt_field_nameOfHospital.setPromptText("Enter name of Hospital");    
    txt_field_hospitalCode = new TextField();
    txt_field_hospitalCode.setPromptText("Enter Hospital Code");    
    txt_field_location = new TextField();
    txt_field_location.setPromptText("Enter Location");    
    txt_field_contactNumber = new TextField();
    txt_field_contactNumber.setPromptText("Enter Contact number");    
    txt_field_email = new TextField();
    txt_field_email.setPromptText("Enter Email");    
    register = new Button ("Register Hospital");    
    
    btn_home1 = new Button("HOME");
    
    VBox hsp_reg1 = new VBox(0,lbl_nameOfHospital,txt_field_nameOfHospital);
    VBox hsp_reg2 = new VBox(0,lbl_hospitalCode,txt_field_hospitalCode);    
    VBox hsp_reg3 = new VBox(0,lbl_location,txt_field_location);
    VBox hsp_reg4 = new VBox(0,lbl_contactNumber,txt_field_contactNumber);    
    VBox hsp_reg5 = new VBox(0,lbl_email,txt_field_email);
    VBox hsp_reg6 = new VBox(2,register);    
    VBox g_pack = new VBox(10,hsp_reg1,hsp_reg2,hsp_reg3,hsp_reg4,hsp_reg5,hsp_reg6);    
    g_pack.setPadding(new Insets(30,50,0,50)); // Adds space at the borders of g    
    BorderPane hosp_reg_bpane = new BorderPane();
    hosp_reg_bpane.setCenter(g_pack); 
    hosp_reg_bpane.setTop(btn_home1);    
    Scene hosp_reg_scene = new Scene(hosp_reg_bpane);
    
    /*HOSPITL REGISTERATION PAGE
    lbl_patient_fName = new Label("First Name");
    lbl_patient_lName= new Label("Last Name");
    lbl_location= new Label("Location");
    lbl_contactNumber = new Label("Contact Number");
    lbl_email= new Label("Email");       
    txt_field_nameOfHospital=new TextField();
    txt_field_nameOfHospital.setPromptText("Enter name of Hospital");    
    txt_field_hospitalCode = new TextField();
    txt_field_hospitalCode.setPromptText("Enter Hospital Code");    
    txt_field_location = new TextField();
    txt_field_location.setPromptText("Enter Location");    
    txt_field_contactNumber = new TextField();
    txt_field_contactNumber.setPromptText("Enter Contact number");    
    txt_field_email = new TextField();
    txt_field_email.setPromptText("Enter Email");    
    register = new Button ("Register Hospital");    
    
    btn_home1 = new Button("HOME");
    
    VBox hsp_reg1 = new VBox(0,lbl_nameOfHospital,txt_field_nameOfHospital);
    VBox hsp_reg2 = new VBox(0,lbl_hospitalCode,txt_field_hospitalCode);    
    VBox hsp_reg3 = new VBox(0,lbl_location,txt_field_location);
    VBox hsp_reg4 = new VBox(0,lbl_contactNumber,txt_field_contactNumber);    
    VBox hsp_reg5 = new VBox(0,lbl_email,txt_field_email);
    VBox hsp_reg6 = new VBox(2,register);    
    VBox g_pack = new VBox(10,hsp_reg1,hsp_reg2,hsp_reg3,hsp_reg4,hsp_reg5,hsp_reg6);    
    g_pack.setPadding(new Insets(30,50,0,50)); // Adds space at the borders of g    
    BorderPane hosp_reg_bpane = new BorderPane();
    hosp_reg_bpane.setCenter(g_pack); 
    hosp_reg_bpane.setTop(btn_home1);    
    Scene hosp_reg_scene = new Scene(hosp_reg_bpane);*/
    
    
    //NEW MAIN PAGE
    HOSPITAL = new Button("SIGN IN AS HOSPITAL");
    HOSPITAL.setMaxWidth(200);
    HDMS = new Button("SIGN IN AS HDMS");
    HDMS.setMaxWidth(200);
    VBox sign = new VBox(10,HDMS,HOSPITAL);
    sign.setPadding(new Insets(300,400,0,600));
    BorderPane newmain_pane = new BorderPane();
    newmain_pane.setCenter(sign);
    //Scene scene_sign = new Scene(newmain_pane);
    Scene scene_sign = new Scene(newmain_pane);
    
    //hospital sigin and signup page
    btn_hosp_signup_home1 = new Button("HOME");
    btn_hosp_signup_SigninAndSignupPage = new Button("SIGNUP");
    btn_hosp_signup_SigninAndSignupPage.setMaxWidth(200);
    btn_hosp_signin_SigninAndSignupPage = new Button("SIGNIN");
    btn_hosp_signin_SigninAndSignupPage.setMaxWidth(200);
    VBox hosp_sign_vbox = new VBox(10,btn_hosp_signin_SigninAndSignupPage,btn_hosp_signup_SigninAndSignupPage);
    hosp_sign_vbox.setPadding(new Insets(300,400,0,600));
    BorderPane hosp_sign_pane = new BorderPane();
    hosp_sign_pane.setTop(btn_hosp_signup_home1);
    hosp_sign_pane.setCenter(hosp_sign_vbox);  
    Scene scene_hosp_sign_and_signup = new Scene(hosp_sign_pane,300,300);
    
    
    
    
    //CENTRAL LOGIN PAGE
    txt_field_central_login_ID = new TextField();
    txt_field_central_login_ID.setPromptText("Enter ID");
    txt_field_central_login_pas = new PasswordField();
    txt_field_central_login_pas.setPromptText("Enter Password");    
    btn_central_login = new Button("login");
    home_main = new Button("HOME");
    lbl_central_login_ID = new Label("ID");
    lbl_central_login_pas = new Label("Password");
    
    VBox central_login1 = new VBox(0,lbl_central_login_ID,txt_field_central_login_ID);
    VBox central_login2 = new VBox(0,lbl_central_login_pas,txt_field_central_login_pas);
    VBox central_login3 = new VBox(0,btn_central_login);
    VBox central_login4 = new VBox(10,central_login1,central_login2,central_login3);
    central_login4.setPadding(new Insets(300,400,0,400));
    BorderPane central_login_pane = new BorderPane();
    central_login_pane.setCenter(central_login4);
    central_login_pane.setTop(home_main);
   

    Scene central_loginScene = new Scene(central_login_pane);
    
    //HOSP SIGN IN PAGE
    btn_hosp_signin_home2 = new Button("HOME");
    txt_field_hosp_login_ID = new TextField();
    txt_field_hosp_login_ID.setPromptText("Enter Certified ID");
    txt_field_hosp_login_pas = new PasswordField();
    txt_field_hosp_login_pas.setPromptText("Enter Password");    
    btn_hosp_login = new Button("login");
    
    lbl_hosp_login_ID = new Label("CERTIFIED ID");
    lbl_hosp_login_pas = new Label("Password");
    
    VBox hosp_login1 = new VBox(0,lbl_hosp_login_ID,txt_field_hosp_login_ID);
    VBox hosp_login2 = new VBox(0,lbl_hosp_login_pas,txt_field_hosp_login_pas);
    VBox hosp_login3 = new VBox(0,btn_hosp_login);
    VBox hosp_login4 = new VBox(10,hosp_login1,hosp_login2,hosp_login3);
    hosp_login4.setPadding(new Insets(300,400,0,400));
    BorderPane hosp_login_pane = new BorderPane();
    hosp_login_pane.setCenter(hosp_login4);
    hosp_login_pane.setTop(btn_hosp_signin_home2);
   

    Scene hosp_login_scene = new Scene(hosp_login_pane);
    
    
    //HOSP SIGNUP PAGE
    // Initialize labels
        lblHospSignupHospitalCode = new Label("HOSPITAL CODE");
        lblHospSignupFirstName = new Label("FIRST NAME");
        lblHospSignupLastName = new Label("LAST NAME");
        lblHospSignupEmail = new Label("EMAIL");
        lblHospSignupContactNumber = new Label("CONTACT NUMBER");
        lblHospSignupCertifiedId = new Label("Enter your Certified ID");
        lblHospSignupPasssword1 = new Label("Enter Password");
        lblHospSignupPasssword2 = new Label("Confirm Password");

        // Initialize text fields with prompt texts
        txtFieldHospSignupHospitalCode = new TextField();
        txtFieldHospSignupHospitalCode.setPromptText("Hospital Code");

        txtFieldHospSignupFirstName = new TextField();
        txtFieldHospSignupFirstName.setPromptText("First Name");

        txtFieldHospSignupLastName = new TextField();
        txtFieldHospSignupLastName.setPromptText("Last Name");

        txtFieldHospSignupEmail = new TextField();
        txtFieldHospSignupEmail.setPromptText("Email");

        txtFieldHospSignupContactNumber = new TextField();
        txtFieldHospSignupContactNumber.setPromptText("Contact Number");
        
        txtFieldHospSignupCertifiedId = new TextField();
        txtFieldHospSignupCertifiedId.setPromptText("Certified ID");
        
        HospSignupPassword1 = new PasswordField();
        HospSignupPassword1.setPromptText("PASSWORD");
        
        HospSignupPassword2 = new PasswordField();
        HospSignupPassword2.setPromptText("CONFIRM PASSWORD");
        

        // Initialize buttons
        btnHospSignup = new Button("SIGNUP");
        signup_page_btnHome = new Button("Home");
        
        DOCTOR = new RadioButton("DOCTOR");
        NURSE = new RadioButton("NURSE");
        staff_group = new ToggleGroup();
        DOCTOR.setToggleGroup(staff_group);
        NURSE.setToggleGroup(staff_group);

        // Create VBoxes for each control pair
        VBox hospSignupBox1 = new VBox(0, lblHospSignupHospitalCode, txtFieldHospSignupHospitalCode);
        VBox hospSignupBox2 = new VBox(0, lblHospSignupFirstName, txtFieldHospSignupFirstName);
        VBox hospSignupBox3 = new VBox(0, lblHospSignupLastName, txtFieldHospSignupLastName);
        VBox hospSignupBox4 = new VBox(0, lblHospSignupEmail, txtFieldHospSignupEmail);
        VBox hospSignupBox5 = new VBox(0, lblHospSignupContactNumber, txtFieldHospSignupContactNumber);
        VBox hospSignupBox6 = new VBox(0, DOCTOR,NURSE);
        VBox hospSignupBox7 = new VBox(0, lblHospSignupCertifiedId, txtFieldHospSignupCertifiedId);
        VBox hospSignupBox8 = new VBox(0, lblHospSignupPasssword1, HospSignupPassword1);
        VBox hospSignupBox9 = new VBox(0, lblHospSignupPasssword2, HospSignupPassword2);
        VBox hospSignupBox10 = new VBox(2, btnHospSignup);

        // Main container
        VBox signupPack = new VBox(10, hospSignupBox1, hospSignupBox2,
                hospSignupBox3, hospSignupBox4,
                hospSignupBox5, hospSignupBox6,
                hospSignupBox7,hospSignupBox8,
                hospSignupBox9,hospSignupBox10);
        signupPack.setPadding(new Insets(30, 50, 0, 50));

        // BorderPane layout
        BorderPane hospSignupBP = new BorderPane();
        hospSignupBP.setCenter(signupPack);
        hospSignupBP.setTop(signup_page_btnHome);
        Scene scene_hosp_signup = new Scene(hospSignupBP);
        
        
    //HOME PAGE  FOR HDMS
    btn_reg_hosp = new Button("REGISTER HOSPITAL");
    btn_view_reg_hosp = new Button("SEARCH REGISTERED HOSPITALS");
    btn_view_reg_patients = new Button("SEARCH REGISTERED PATIENTS");
    
    SIGNOUT_HDMS = new Button("testing");
      
    VBox home_layout = new VBox(30,btn_reg_hosp,btn_view_reg_hosp,btn_view_reg_patients);
    home_layout.setAlignment(Pos.CENTER);
    home_layout.setPadding(new Insets(20,20,20,20));
    BorderPane home_pane = new BorderPane();
    
    home_pane.setTop(SIGNOUT_HDMS);
    home_pane.setCenter(home_layout);
    
    Scene scene_central_home = new Scene(home_pane,1300,700);
    
    
    //HOME PAGE FOR HOSPITALS
    btn_hosp_retrieve_records = new Button("RETRIEVE MEDICAL RECORDS");
    btn_hosp_upload_records = new Button("UPLOAD MEDICAL RECORDS");
    btn_hosp_reg_patients = new Button("REGISTER PATIENT");
    SIGNOUT_HOSPITALS = new Button("SIGNOUT___");
      
    VBox hosp_home_layout = new VBox(30,btn_hosp_retrieve_records,btn_hosp_upload_records,btn_hosp_reg_patients);
    hosp_home_layout.setAlignment(Pos.CENTER);
    hosp_home_layout.setPadding(new Insets(20,20,20,20));
    BorderPane hosp_home_pane = new BorderPane();
    hosp_home_pane.setTop(SIGNOUT_HOSPITALS);
    hosp_home_pane.setCenter(hosp_home_layout);
    
    Scene scene_hosp_home = new Scene(hosp_home_pane,1300,700);
    
    
    
    
    
    
    
    
    
    
    // PATIENT SEARCH PAGE
lbl_patientFirstName = new Label("FIRST NAME: ");
lbl_patientFirstName_value = new Label();

lbl_patientLastName = new Label("LAST NAME: ");
lbl_patientLastName_value = new Label();

lbl_patientSearch_location = new Label("LOCATION: ");
lbl_patientSearch_location_value = new Label();

lbl_patientSearch_contact = new Label("CONTACT: ");
lbl_patientSearch_contact_value = new Label();

lbl_patientSearch_email = new Label("EMAIL: ");
lbl_patientSearch_email_value = new Label();

lbl_patientSearch_regDate = new Label("REGISTRATION DATE: ");
lbl_patientSearch_regDate_value = new Label();

lbl_patient_gender = new Label("GENDER: ");
lbl_patient_gender_value = new Label();

lbl_patient_nationalId = new Label("NATIONAL ID: ");
lbl_patient_nationalId_value = new Label();

// Radio buttons for search options
byName = new RadioButton("SEARCH BY NAME");
byId = new RadioButton("SEARCH BY ID");

// Grouping radio buttons
patient_group = new ToggleGroup();
byName.setToggleGroup(patient_group);
byId.setToggleGroup(patient_group);

btn_home3 = new Button("HOME");

// Text field for entering search query
txt_field_patientSearch = new TextField();

btn_search_patient = new Button("SEARCH");

// Layout setup
//HBox hbox_patientSearch = new HBox(20, byName, byId);
HBox patientSearch_hbox = new HBox(10, txt_field_patientSearch, byName, byId);
VBox patientSearch_vbox = new VBox(5,
        patientSearch_hbox,
    lbl_patientFirstName, lbl_patientFirstName_value,
    lbl_patientLastName, lbl_patientLastName_value,
    lbl_patientSearch_location, lbl_patientSearch_location_value,
    lbl_patientSearch_contact, lbl_patientSearch_contact_value,
    lbl_patientSearch_email, lbl_patientSearch_email_value,
    lbl_patientSearch_regDate, lbl_patientSearch_regDate_value,
    lbl_patient_gender, lbl_patient_gender_value,
    lbl_patient_nationalId, lbl_patient_nationalId_value,btn_search_patient
);

// Setting up BorderPane layout
BorderPane bpane_patientSearch = new BorderPane();
bpane_patientSearch.setTop(btn_home3); 
//bpane_patientSearch.setTop(patientSearch_hbox);
bpane_patientSearch.setCenter(patientSearch_vbox);

// Scene setup
Scene scene_patientSearch = new Scene(bpane_patientSearch);
primaryStage.setMaximized(true);

    
    
    //HOSPITAL SEARCH PAGE
    btn_home2 = new Button("HOME");
    lbl_hospSearch_hospName = new Label("NAME: ");
    lbl_hospSearch_hospName_value = new Label();
    HBox hbox_hospName = new HBox(lbl_hospSearch_hospName, lbl_hospSearch_hospName_value);

    lbl_hospSearch_hospCode = new Label("HOSPITAL CODE: "); 
    lbl_hospSearch_hospCode_value = new Label();
    HBox hbox_hospCode = new HBox(lbl_hospSearch_hospCode, lbl_hospSearch_hospCode_value);

    

    lbl_hospSearch_contact = new Label("CONTACT: ");
    lbl_hospSearch_contact_value = new Label();
    HBox hbox_contact = new HBox(lbl_hospSearch_contact, lbl_hospSearch_contact_value);

    lbl_hospSearch_email = new Label("EMAIL: ");
    lbl_hospSearch_email_value = new Label();
    HBox hbox_email = new HBox(lbl_hospSearch_email, lbl_hospSearch_email_value);

    lbl_hospSearch_regDate = new Label("REGISTRATION DATE: ");
    lbl_hospSearch_regDate_value = new Label();
    HBox hbox_regDate = new HBox(lbl_hospSearch_regDate, lbl_hospSearch_regDate_value);    
    
    lbl_hospSearch_location = new Label("LOCATION: ");
    lbl_hospSearch_location_value = new Label();
    HBox hbox_location = new HBox(lbl_hospSearch_location,lbl_hospSearch_location_value);
    
    hsp_byName = new RadioButton("SEARCH BY NAME");
    hsp_byId = new RadioButton("SEARCH BY ID");
    //HBox hsp_hbox_patientSearch = new HBox(20,hsp_byName,hsp_byId);
    txt_field_hospSearch = new TextField(); 
    hsp_group = new ToggleGroup();
    hsp_byName.setToggleGroup(hsp_group);
    hsp_byId.setToggleGroup(hsp_group);
    

    
    
    HBox hsp_hbox_hospSearch = new HBox(40,hsp_byName,hsp_byId,txt_field_hospSearch);
    VBox hsp_vbox_hospSearch= new VBox(hsp_hbox_hospSearch,hbox_hospName,hbox_hospCode,hbox_contact,hbox_email,hbox_regDate,hbox_location,btn_search_hosp);
    hsp_vbox_hospSearch.setPadding(new Insets(20,20,20,20));
    BorderPane hsp_bpane_hospSearch = new BorderPane();
    hsp_bpane_hospSearch.setCenter(hsp_vbox_hospSearch);
    hsp_bpane_hospSearch.setTop(btn_home2);
    Scene scene_hospSearch = new Scene(hsp_bpane_hospSearch);
    
    
    
    

    String csss = getClass().getResource("styles.css").toExternalForm();
    String css1 = getClass().getResource("styles_1.css").toExternalForm();
    hosp_reg_scene.getStylesheets().add(css1);
    central_loginScene.getStylesheets().add(css1);
    scene_central_home.getStylesheets().add(css1);
    scene_hospSearch.getStylesheets().add(css1);
    scene_hosp_sign_and_signup.getStylesheets().add(css1);
    scene_hosp_home.getStylesheets().add(css1);
    
    
    //CSS
    scene_patientSearch.getStylesheets().add(css1);
    scene_sign.getStylesheets().add(css1);
    hosp_login_scene.getStylesheets().add(css1);
    scene_hosp_signup.getStylesheets().add(css1);
    
    //primaryStage.setScene(hosp_reg_scene);
    //primaryStage.setScene(central_login_scene);
    primaryStage.setScene(scene_sign);
    primaryStage.setTitle("HOSPITAL REGISTERATION");    
    primaryStage.show();
    primaryStage.setMaximized(true);
    //primaryStage.setResizable(false);
    
    register.setOnAction(e ->{empty_fill_check();}    );
    btn_central_login.setOnAction(e -> {central_login(primaryStage,scene_central_home);primaryStage.setMaximized(true);});
    btn_hosp_login.setOnAction(e -> {hosp_login(primaryStage, scene_hosp_home);});
    


    btn_reg_hosp.setOnAction(e-> {primaryStage.setScene(hosp_reg_scene);primaryStage.setMaximized(true);});
    
    home_main.setOnAction(e->{primaryStage.setScene(scene_sign);primaryStage.setMaximized(true);});
    SIGNOUT_HOSPITALS.setOnAction(e -> {primaryStage.setScene(scene_hosp_sign_and_signup);  primaryStage.setMaximized(true);
    
    empty_fields_central_login(); // Ensure this method exists and works as expected
});

    SIGNOUT_HDMS.setOnAction(e->{primaryStage.setScene(central_loginScene);primaryStage.setMaximized(true);empty_fields_central_login();});
    btn_home1.setOnAction(e->{primaryStage.setScene(scene_central_home);primaryStage.setMaximized(true);});
    btn_home2.setOnAction(e->{primaryStage.setScene(scene_central_home);primaryStage.setMaximized(true);});
    btn_home3.setOnAction(e->{primaryStage.setScene(scene_central_home);primaryStage.setMaximized(true);});
    btn_view_reg_patients.setOnAction(e -> {primaryStage.setScene(scene_patientSearch);primaryStage.setMaximized(true);});
    btn_view_reg_hosp.setOnAction(e -> {primaryStage.setScene(scene_hospSearch);primaryStage.setMaximized(true);});
    btn_search_hosp.setOnAction(e -> fetchHospitalInfo());
    btn_search_patient.setOnAction(e->fetchPatientRecords());
    HDMS.setOnAction(e -> primaryStage.setScene(central_loginScene));
    HOSPITAL.setOnAction(e -> {primaryStage.setScene(scene_hosp_sign_and_signup);primaryStage.setMaximized(true);});
    btn_hosp_signin_SigninAndSignupPage.setOnAction(e -> {primaryStage.setScene(hosp_login_scene);primaryStage.setMaximized(true);});
    btn_hosp_signup_home1.setOnAction(e -> {primaryStage.setScene(scene_sign);primaryStage.setMaximized(true);});
    btn_hosp_signin_home2.setOnAction(e -> {primaryStage.setScene(scene_hosp_sign_and_signup);});
    btn_hosp_signup_SigninAndSignupPage.setOnAction(e -> {primaryStage.setScene(scene_hosp_signup);primaryStage.setMaximized(true);});
    signup_page_btnHome.setOnAction(e -> {primaryStage.setScene(scene_hosp_sign_and_signup);primaryStage.setMaximized(true);});
    btnHospSignup.setOnAction(e -> {handleSignup();primaryStage.setMaximized(true);});
    
    
    
    
        
    }
    
    
   
    public void empty_fields_central_login(){
        txt_field_central_login_pas.clear();
        txt_field_central_login_ID.clear();
        
        
    }
    
    
    public void empty_fill_check(){
        if(txt_field_hospitalCode.getText().isEmpty()||
                txt_field_nameOfHospital.getText().isEmpty()||
                txt_field_location.getText().isEmpty()||
                txt_field_contactNumber.getText().isEmpty()||
                txt_field_email.getText().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("FILL ALL BLANKS");
            alert.setContentText("Please fill all blanks");
            alert.showAndWait();}
        else{
            hospital_reg_upload();
        }
        txt_field_hospitalCode.clear();
        txt_field_nameOfHospital.clear();
        txt_field_location.clear();
        txt_field_contactNumber.clear();
        txt_field_email.clear();
                
    }
    
    public void hospital_reg_upload() {
    // Use a direct JDBC URL string (unless you set it as an env variable)
    String dbUrl = "jdbc:mysql://localhost:3306/hospitalrecords?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String dbUser = "root";  // Replace with your actual MySQL username
    String dbPassword = "jju$tm1ne"; // Replace with your actual password

    String query = "INSERT INTO hospitals (hospital_code,hospital_name,location,contact_number,email) VALUES(?,?,?,?,?)";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, txt_field_hospitalCode.getText());
        pstmt.setString(2,  txt_field_nameOfHospital.getText());
        pstmt.setString(3, txt_field_location.getText());
        pstmt.setString(4, txt_field_contactNumber.getText());
        pstmt.setString(5, txt_field_email.getText());
        int rowInserted = pstmt.executeUpdate();// this line returns the number of rows insereted
                                                // we can use this to determine if there was a problem uploading,
                                                //allowing us to propmpt the user

        if (rowInserted > 0) {
            Alert alert = new Alert(AlertType.INFORMATION);                
            alert.setTitle("SUCCESS");
            alert.setContentText("UPLOAD WAS SUCCESSFUL");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);                
            alert.setTitle("ERROR");
            alert.setContentText("UPLOAD FAILED");
            alert.showAndWait();
        }
    } catch (SQLException e) {
        System.err.println("Error uploading data: " + e.getMessage());
    }
}
    
    
    public void central_login(Stage primaryStage1,Scene scene_central_home) {
    
    // Database connection details
    String dbUrl = "jdbc:mysql://localhost:3306/hospitalrecords?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String dbUser = "root";  // Replace with your actual MySQL username
    String dbPassword = "jju$tm1ne"; // Replace with your actual password

    // SQL query to retrieve login details
    String query = "SELECT id, password FROM admin WHERE id = ? AND password = ?";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        // Set parameters from text fields
        pstmt.setString(1, txt_field_central_login_ID.getText());
        pstmt.setString(2, txt_field_central_login_pas.getText());

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) { // If credentials exist in the database
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setContentText("Welcome!");
            alert.showAndWait();

            
            primaryStage1.setScene(scene_central_home);
            primaryStage1.show();

            Platform.runLater(() -> {
            primaryStage1.setMaximized(true);
            });

            
            //primaryStage1.setResizable(false);
           

            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("Invalid ID or Password");
            alert.showAndWait();
        }

    } catch (SQLException e) {
        System.err.println("Error logging in: " + e.getMessage());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setContentText("Could not connect to the database.");
        alert.showAndWait();
    }
}
    
     public void hosp_login(Stage primaryStage1,Scene scene_hosp_home1) {
    
    // Database connection details
    String dbUrl = "jdbc:mysql://localhost:3306/hospitalrecords?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String dbUser = "root";  // Replace with your actual MySQL username
    String dbPassword = "jju$tm1ne"; // Replace with your actual password

    // SQL query to retrieve login details
    String query = "SELECT staff_id, password_hash FROM staff WHERE staff_id = ? AND password_hash = ?";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        // Set parameters from text fields
        pstmt.setString(1, txt_field_hosp_login_ID.getText());
        pstmt.setString(2, txt_field_hosp_login_pas.getText());

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) { // If credentials exist in the database
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setContentText("Welcome!");
            alert.showAndWait();

            
            primaryStage1.setScene(scene_hosp_home1);
            primaryStage1.show();

            Platform.runLater(() -> {
            primaryStage1.setMaximized(true);
            });

            
            //primaryStage1.setResizable(false);
           

            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("Invalid ID or Password");
            alert.showAndWait();
        }

    } catch (SQLException e) {
        System.err.println("Error logging in: " + e.getMessage());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setContentText("Could not connect to the database.");
        alert.showAndWait();
    }
}
    
   
    
    
    public void fetchHospitalInfo() {
    // Database connection details
    String dbUrl = "jdbc:mysql://localhost:3306/hospitalrecords?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String dbUser = "root";  
    String dbPassword = "jju$tm1ne";  

    // Check which radio button is selected
    Toggle selectedToggle = hsp_group.getSelectedToggle();
    if (selectedToggle == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Selection Required");
        alert.setContentText("Please select a search option (by Name or by Code).");
        alert.showAndWait();
        return;
    }

    RadioButton selectedRadio = (RadioButton) selectedToggle;
    String query;
    String searchValue;

    if (selectedRadio == hsp_byName) {
        query = "SELECT * FROM hospitals WHERE hospital_name = ?";
        searchValue = txt_field_hospSearch.getText(); // Text field where the user enters the hospital name
    } else if (selectedRadio == hsp_byId) {
        query = "SELECT * FROM hospitals WHERE hospital_code = ?";
        searchValue = txt_field_hospSearch.getText(); // Text field where the user enters the hospital code
    } else {
        return;
    }

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, searchValue);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Update labels with retrieved data
            lbl_hospSearch_regDate_value.setText(rs.getString("registration_date"));
            lbl_hospSearch_email_value.setText(rs.getString("email"));
            lbl_hospSearch_contact_value.setText(rs.getString("contact_number"));
            lbl_hospSearch_location_value.setText(rs.getString("location"));
            lbl_hospSearch_hospCode_value.setText(rs.getString("hospital_code"));
            lbl_hospSearch_hospName_value.setText(rs.getString("hospital_name"));
            lbl_hospSearch_location_value.setText(rs.getString("location"));
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setContentText("No hospital found with the given details.");
            alert.showAndWait();
        }
    } catch (SQLException e) {
        System.err.println("Database error: " + e.getMessage());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setContentText("Could not retrieve hospital information.");
        alert.showAndWait();
    }
}
    
    public void fetchPatientRecords() {
    // Database connection details
    String dbUrl = "jdbc:mysql://localhost:3306/hospitalrecords?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String dbUser = "root";  
    String dbPassword = "jju$tm1ne";  

    // Check which radio button is selected
    Toggle selectedToggle = patient_group.getSelectedToggle();
    if (selectedToggle == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Selection Required");
        alert.setContentText("Please select a search option (by Name or by ID).");
        alert.showAndWait();
        return;
    }

    RadioButton selectedRadio = (RadioButton) selectedToggle;
    String query;
    String searchValue = txt_field_patientSearch.getText().trim(); // Get user input

    if (searchValue.isEmpty()) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Input Required");
        alert.setContentText("Please enter a search value.");
        alert.showAndWait();
        return;
    }

    if (selectedRadio == byName) {
        query = "SELECT * FROM patients WHERE first_name = ? OR last_name = ?";
    } else if (selectedRadio == byId) {
        query = "SELECT * FROM patients WHERE national_id = ?";
    } else {
        return;
    }

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        if (selectedRadio == byName) {
            pstmt.setString(1, searchValue);
            pstmt.setString(2, searchValue);
        } else {
            pstmt.setString(1, searchValue);
        }

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Update labels with retrieved data
            lbl_patientFirstName_value.setText(rs.getString("first_name"));
            lbl_patientLastName_value.setText(rs.getString("last_name"));
           // lbl_patientSearch_location_value.setText(rs.getString("hospital_code")); // Assuming hospital represents location
            lbl_patientSearch_contact_value.setText(rs.getString("contact_number"));
            lbl_patientSearch_email_value.setText(rs.getString("email"));
            lbl_patientSearch_regDate_value.setText(rs.getString("registration_date"));
            lbl_patient_gender_value.setText(rs.getString("gender"));
            lbl_patient_nationalId_value.setText(rs.getString("national_id"));
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setContentText("No patient found with the given details.");
            alert.showAndWait();
        }
    } catch (SQLException e) {
        System.err.println("Database error: " + e.getMessage());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setContentText("Could not retrieve patient information.");
        alert.showAndWait();
    }
}
    
    
    
    //registering hospital staff
    public void handleSignup() {
    // Retrieve user input
    String hospitalCode = txtFieldHospSignupHospitalCode.getText().trim();
    String firstName = txtFieldHospSignupFirstName.getText().trim();
    String lastName = txtFieldHospSignupLastName.getText().trim();
    String staffID = txtFieldHospSignupCertifiedId.getText().trim(); // User-provided staff ID
    String email = txtFieldHospSignupEmail.getText().trim();
    String contactNumber = txtFieldHospSignupContactNumber.getText().trim();
    String certifiedId = txtFieldHospSignupCertifiedId.getText().trim();
    String password1 = HospSignupPassword1.getText().trim();
    String password2 = HospSignupPassword2.getText().trim();

    // Check selected role
    String role = "";
    if (DOCTOR.isSelected()) {
        role = "Doctor";
    } else if (NURSE.isSelected()) {
        role = "Nurse";
    } else {
        showAlert("Error", "Please select a role (Doctor/Nurse)");
        return;
    }

    // Validate input fields
    if (hospitalCode.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
        contactNumber.isEmpty() || certifiedId.isEmpty() || staffID.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
        showAlert("Error", "All fields must be filled");
        return;
    }

    // Check if passwords match
    if (!password1.equals(password2)) {
        showAlert("Error", "Passwords do not match");
        return;
    }

    // Establish database connection
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalrecords", "root", "jju$tm1ne")) {
        
        // Step 1: Check if hospital code exists and get hospital_key
        String checkHospitalQuery = "SELECT hospital_key FROM hospitals WHERE hospital_code = ?";
        int hospitalKey = -1; // Default invalid value

        try (PreparedStatement stmt = conn.prepareStatement(checkHospitalQuery)) {
            stmt.setString(1, hospitalCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                hospitalKey = rs.getInt("hospital_key"); // Get hospital's primary key
            } else {
                showAlert("Error", "Invalid Hospital Code");
                return;
            }
        }

        // Step 2: Insert new staff member with retrieved hospital_key
        String insertQuery = "INSERT INTO STAFF (first_name, last_name, staff_id, rolle, hospital_key, password_hash, email, contact_number, certified_id) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, firstName);
            insertStmt.setString(2, lastName);
            insertStmt.setString(3, staffID); // Use user-provided staff ID
            insertStmt.setString(4, role);
            insertStmt.setInt(5, hospitalKey); // Store the hospital's primary key as foreign key
            insertStmt.setString(6, password1); // No hashing for now
            insertStmt.setString(7, email);
            insertStmt.setString(8, contactNumber);
            insertStmt.setString(9, certifiedId);

            int rowsAffected = insertStmt.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Staff registered successfully!");
            } else {
                showAlert("Error", "Registration failed. Please try again.");
            }
            clearSignupFields();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Error", "Database error: " + e.getMessage());
    }
}

// Function to show alerts
private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
//FUNCTION TO CLEAR ALL ENTRIES ON HOS SIGNUP PAGE
private void clearSignupFields() {
    txtFieldHospSignupHospitalCode.clear();
    txtFieldHospSignupFirstName.clear();
    txtFieldHospSignupLastName.clear();
    txtFieldHospSignupEmail.clear();
    txtFieldHospSignupContactNumber.clear();
    txtFieldHospSignupCertifiedId.clear();
    txtFieldHospSignupCertifiedId.clear(); // Assuming you have a staff ID field
    HospSignupPassword1.clear();
    HospSignupPassword2.clear();
    staff_group.selectToggle(null); // Deselect radio buttons (Doctor/Nurse)
}


    
    
}
