// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.PowerDistribution;


public class Robot extends TimedRobot {

  RobotContainer m_robotContainer;
  private final PowerDistribution pd = new PowerDistribution();
  
  @Override
  public void robotInit() { 
     
    pd.clearStickyFaults();
    m_robotContainer = new RobotContainer();
    
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putBoolean("brownout", pd.getStickyFaults().Brownout);
    SmartDashboard.putBoolean("canbusoff", pd.getStickyFaults().CanBusOff);
    SmartDashboard.putBoolean("canbuswarning", pd.getStickyFaults().CanWarning);
    SmartDashboard.putBoolean("breaker12", pd.getStickyFaults().Channel12BreakerFault);
    SmartDashboard.putBoolean("breaker13", pd.getStickyFaults().Channel13BreakerFault);
    SmartDashboard.putBoolean("breaker14", pd.getStickyFaults().Channel14BreakerFault);
    SmartDashboard.putBoolean("breaker15", pd.getStickyFaults().Channel15BreakerFault);
    SmartDashboard.putBoolean("reset", pd.getStickyFaults().HasReset);
    // SmartDashboard.putBoolean("breaker13", pd.getStickyFaults().Channel13BreakerFault);
    // SmartDashboard.putBoolean("breaker14", pd.getStickyFaults().Channel14BreakerFault);
    // SmartDashboard.putBoolean("breaker15", pd.getStickyFaults().Channel15BreakerFault);
    // SmartDashboard.putBoolean("breaker12", pd.getStickyFaults().Channel12BreakerFault);
    // SmartDashboard.putBoolean("breaker13", pd.getStickyFaults().Channel13BreakerFault);
    // SmartDashboard.putBoolean("breaker14", pd.getStickyFaults().Channel14BreakerFault);
    // SmartDashboard.putBoolean("breaker15", pd.getStickyFaults().Channel15BreakerFault);

    
  }
  }

   /*leftFront.setIdleMode(IdleMode.kCoast);
    leftBack.setIdleMode(IdleMode.kCoast);
    rightFront.setIdleMode(IdleMode.kCoast);
    rightBack.setIdleMode(IdleMode.kCoast);
    */