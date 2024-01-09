package applications

import applications.tests.chemistry.VTestChemistry
import applications.tests.electronics.VTestElectronics
import applications.tests.radiation.VTestEmissions
import applications.tests.nuclear.VTestNeutrons
import symmetrical.cosmic.absorber.Absorber

object TestPhysics {
    @JvmStatic
    fun main(args: Array<String>) {
        Absorber.initialize(TestPhysicsEmitters())

        // To see Virtual Physics in action, it is best to run thse
        // test cases and step through the code in the debugger to see
        // some of the inner workings of physics
        VTestElectronics().test()
        VTestEmissions().test()
        VTestNeutrons().test()
        VTestChemistry().test()
    }

}