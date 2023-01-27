// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class nAvXCom extends CommandBase {
  /** Creates a new nAvXCom. */
  private AHRS navx;
  public nAvXCom() {
    // Use addRequirements() here to declare subsystem dependencies.
    try{
      navx = new AHRS( SPI.Port.kMXP);
    } catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double yAw = navx.getAngle();
    SmartDashboard.putData(navx);
    SmartDashboard.putNumber("NAVXANGLE", yAw);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
