package applications

import applications.tests.chemistry.VTestChemistry
import applications.tests.dictionary.TestPhysicsEmitters
import applications.tests.electronics.VTestElectronics
import applications.tests.elements.VTestElements
import applications.tests.radiation.VTestRadiation
import applications.tests.nuclear.VTestNeutrons
import applications.tests.quarks.VTestQuarks
import applications.tests.typeConverter.VTestTypeConverter
import symmetrical.dictionary.absorber.Absorber

object RunMe {
    @JvmStatic
    fun main(args: Array<String>) {
        Absorber.initialize(TestPhysicsEmitters())

        // To see Virtual Physics in action, it is best to run thse
        // test cases and step through the code in the debugger to see
        // some of the inner workings of physics
        VTestQuarks().test()
        VTestElements().test()
        VTestRadiation().test()
        VTestNeutrons().test()
        VTestChemistry().test()
        VTestElectronics().test()
        VTestTypeConverter().test()

    }

}