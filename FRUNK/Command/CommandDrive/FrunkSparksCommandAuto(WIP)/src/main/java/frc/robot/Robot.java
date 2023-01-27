// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutoCommandDefault;
import frc.robot.subsystems.ArcadeDriveSub;

public class Robot extends TimedRobot {

 private final ArcadeDriveSub ArcadeDriveSub = new ArcadeDriveSub();

  RobotContainer m_robotContainer;
  Command auto;
  private String m_autoSelected;
  private final SendableChooser<String> m_Chooser = new SendableChooser<>();
  private final String kDefaultAuto = "Default";
  private final String kCustomAuto = "My Auto";

  @Override
  public void robotInit() {  
    m_robotContainer = new RobotContainer();
    auto = new AutoCommandDefault(ArcadeDriveSub);
    m_Chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_Chooser.addOption("My Auto", kCustomAuto);
  }

  @Override
  public void autonomousInit() {
    if (auto != null) auto.schedule();
    m_autoSelected = m_Chooser.getSelected();
    System.out.println("Auto Selected: "+ m_autoSelected);
  }
  public void autonomousPeriodic(){
    CommandScheduler.getInstance().run();

    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopPeriodic() {

}
  @Override
  public void robotPeriodic(){
    CommandScheduler.getInstance().run();
  }

}

   