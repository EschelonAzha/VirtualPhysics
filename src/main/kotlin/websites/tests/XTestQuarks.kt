package websites.tests

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic._physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString


object XTestQuarks {
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

        val quark = Quark()
        val up = Up()

        var test = Quark()
        var boson1 = Quark.Args("1")
        var boson2 = Quark.Args("2")

        test.z(Quark.Args(""))
        var numTimes = 0


        var qDouble = QDouble()

        qDouble.setDouble(22.3)

  //      var result = qDouble.blue()

        var qString = QString()
        qString.setString("abc")

   //     var redString   = qString.red()
   //     var blueString  = qString.blue()
   //     var greenString = qString.green()
   //     blueString = qString.blue()


        var qInt   = QInt()
        qInt.setInt(2020)
//        var red    = qInt.red()
//        var blue   = qInt.blue()
//        var green  = qInt.green()


//        blue    = qInt.blue()
//        red     = qInt.red()
//        green   = qInt.green()


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

 //       var result = qDouble.red()

        var qString = QString()
        qString.setString("abc")
   //     var redString   = qString.red()

        var qInt   = QInt()
        qInt.setInt(2020)
   //     var red    = qInt.red()
    }

}