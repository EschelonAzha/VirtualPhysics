package websites.tests


import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic._physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString


object XTestWavelengths {
    // run main then
    // localhost:8081/FabricFlowNode
    @JvmStatic
    fun main(args: Array<String>) {
        // This should create a new Universe where all the forces and matter
        // combine and can easily be addressed structurally without named lookups
        // In theory each force shouldn't know about the other and should be
        // able to attach and remove run or transform in a way that is independent
        // of all the other forces.    Each force should act alone
        // Yes I know, nearly impossible, but I will do it!



        var qDouble = QDouble()

        qDouble.setDouble(22.3)

        var result = qDouble.getElectronPhoton()
        var wavelength:Double = qDouble.getElectronWavelength()
        var spin = qDouble.getElectronSpin()

        var qString = CrLfTerminatedString()
        qString.setString("abc")

        var redString   = qString.getElectronWavelength()
        var blueString  = qString.getElectronPhoton()
        var greenString = qString.getElectronSpin()



        var qInt   = QInt()
   //     qInt.setGreen(CRLFTerminatedColor())
        qInt.setInt(2020)
        var red    = qInt.getElectronWavelength()
        var blue   = qInt.getElectronPhoton()
        var green  = qInt.getElectronSpin()

        var fieldName = qInt.getFieldName()
        qInt.setFieldName("some name")

        var neutron = qInt.getNeutron(Down.TEST_PROPERTY)
        neutron.setValue(null)

        qInt.wind(Down.VALUE)

//        var universe = Universe().bigBang(PlanetaryTraveler_Gravity(),
//            PlanetaryTraveler_Higgs(),
//            PlanetaryTraveler_Magnetism(),
//            PlanetaryTraveler_Strong()
//
//        )

    }

    fun timer() {
        var qDouble = QDouble()
        qDouble.setDouble(22.3)

        var result = qDouble.red()

        var qString = QString()
        qString.setString("abc")
        var redString   = qString.red()

        var qInt   = QInt()
        qInt.setInt(2020)
        var red    = qInt.red()
    }

}