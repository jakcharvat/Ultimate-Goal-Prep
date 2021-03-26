package org.firstinspires.ftc.teamcode.baseClasses

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix
import org.firstinspires.ftc.teamcode.baseClasses.navigation.AutonomousTarget

abstract class MecanumAutoOpMode: BaseLinearOpMode() {
    abstract var autonomousSide: AutonomousSide

    /**
     * The main action loop
     */
    @Throws(InterruptedException::class)
    abstract fun mecaLoop()


    fun driveToTarget(target: AutonomousTarget) {
        val targetMatrix = target.positionMatrix(autonomousSide)
    }


    override fun runLoop() {
        waitForStart()

        while (opModeIsActive()) {
            mecaLoop()
        }
    }


    enum class AutonomousSide {
        RED, BLUE
    }
}