package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.networktables.NetworkTableInstance.NetworkMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.lib.interfaces.Swerve.GyroIO;
import frc.robot.lib.interfaces.Swerve.GyroPigeon2;
import frc.robot.lib.interfaces.Swerve.Swerve;
import frc.robot.lib.interfaces.Swerve.SwerveModuleFalcon500;
import frc.robot.lib.interfaces.Swerve.SwerveModuleIO;
import frc.robot.subsystems.drive.DrivetrainStateMachine;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;

public class RobotMap {

    /* state machine instances */
    public static DrivetrainStateMachine drivetrainStateMachine;
    

    /* Motor instances */
    public static WPI_Pigeon2 gyro;
    // public static WPI_TalonFX leftElbowMotor;
    // public static WPI_TalonFX rightElbowMotor;
    // public static WPI_TalonFX leftShoulderMotor;
    // public static WPI_TalonFX rightShoulderMotor;
    // public static VictorSPX intakeMotor;

    /* Smart Dashboard Instances */
    public static Field2d Field2d;

    /* Interface instances */
   
    public static Swerve swerve; 
    // public static Arm arm;
   

    /* Xbox controllers */
    public static XboxController manipulatorController;
    public static XboxController driverController;

    public static void init() {
        
        gyro = new WPI_Pigeon2(Constants.CAN_IDS.PIDGEON, "Swerve");

        // leftShoulderMotor = new WPI_TalonFX(Constants.CAN_IDS.LEFT_SHOULDER_MOTOR);
        // rightShoulderMotor = new WPI_TalonFX(Constants.CAN_IDS.RIGHT_SHOULDER_MOTOR);
        // leftElbowMotor = new WPI_TalonFX(Constants.CAN_IDS.LEFT_ELBOW_MOTOR);
        // rightElbowMotor = new WPI_TalonFX(Constants.CAN_IDS.RIGHT_ELBOW_MOTOR);
        // intakeMotor = new VictorSPX(Constants.CAN_IDS.INTAKE_MOTOR);

        swerve = new Swerve(); 
        gyro.configFactoryDefault();
        // leftShoulderMotor.configFactoryDefault();
        // rightShoulderMotor.configFactoryDefault();
        // leftElbowMotor.configFactoryDefault();
        // rightElbowMotor.configFactoryDefault();
        // intakeMotor.configFactoryDefault();
        
        
        switch(Constants.currentMode){
            case REAL:
                
                    break;
            default:
                break;
    
    }        /* By pausing init for a second before setting module offsets, we avoid a bug with inverting motors.
        * See https://github.com/Team364/BaseFalconSwerve/issues/8 for more info. */
        Timer.delay(1.0);


        manipulatorController = new XboxController(1);
        driverController = new XboxController(0);

        swerve.periodic();
        // elevator.periodic();
        // wrist.periodic();
        // intake.periodic();
        
        swerve.resetModulesToAbsolute();
        swerve.zeroGyro();
        
        
        // arm = new Arm();
        Field2d = new Field2d();
        
        drivetrainStateMachine = new DrivetrainStateMachine();
       
    }
}
// initiate bomb sequence