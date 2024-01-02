package applications

import applications.tests.VTestElectronics
import applications.tests.VTestEmissions
import applications.tests.VTestNeutrons
import symmetrical.cosmic.__recycle.Absorber

object TestPhysics {
    @JvmStatic
    fun main(args: Array<String>) {
        Absorber.initialize(TestPhysicsEmitters())

        VTestElectronics().test()
        VTestEmissions().test()
        VTestNeutrons().test()
    }

}