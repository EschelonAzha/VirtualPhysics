package applications

import applications.tests.VTestElectronics
import symmetrical.cosmic.__recycle.Absorber

object TestPhysics {
    @JvmStatic
    fun main(args: Array<String>) {
        Absorber.initialize(TestPhysicsEmitters())

        VTestElectronics().test()
    }

}