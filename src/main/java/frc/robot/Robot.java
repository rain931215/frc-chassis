// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the methods corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    // Left Motor Controllers
    private final SpeedControllerGroup m_left = new SpeedControllerGroup(new WPI_VictorSPX(1),new WPI_VictorSPX(2));
    // Right Motor Controllers
    private final SpeedControllerGroup m_right = new SpeedControllerGroup(new WPI_VictorSPX(3), new WPI_VictorSPX(4));
    // Differential Drive Object
    private final DifferentialDrive robot = new DifferentialDrive(m_left,m_right);
    // Xbox Controller
    private final XboxController controller = new XboxController(0);


    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {}

    /**
     * This method is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     * <p>
     * This runs after the mode specific periodic methods, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {}

    /**
     * This autonomous (along with the chooser code above) shows how to select between different
     * autonomous modes using the dashboard. The sendable chooser code works with the Java
     * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
     * uncomment the getString line to get the auto name from the text box below the Gyro.
     * <p>
     * You can add additional auto modes by adding additional comparisons to the switch structure
     * below with additional strings. If using the SendableChooser make sure to add them to the
     * chooser code above as well.
     */
    @Override
    public void autonomousInit() {}

    /** This method is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {}

    /** This function is called once when teleop is enabled. */
    @Override
    public void teleopInit() {}

    /** This method is called periodically during operator control. */
    @Override
    public void teleopPeriodic() {
        // Update speed in teleop loop
        // xSpeed: forward speed
        // zRotation: rotation speed
        double xSpeed = -controller.getY(GenericHID.Hand.kLeft);
        double zRotation = controller.getX(GenericHID.Hand.kRight);
        robot.arcadeDrive(xSpeed,zRotation);
    }

    /** This function is called once when the robot is disabled. */
    @Override
    public void disabledInit() {
        // Stop motors
        robot.arcadeDrive(0,0);
    }

    /** This function is called periodically when disabled. */
    @Override
    public void disabledPeriodic() {}

    /** This function is called once when test mode is enabled. */
    @Override
    public void testInit() {}

    /** This method is called periodically during test mode. */
    @Override
    public void testPeriodic() {}
}
