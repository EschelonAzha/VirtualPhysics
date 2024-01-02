package applications.tests

import symmetrical.cosmic._physics.atomic.atoms.Atom
import applications.tests.dictionary.Rejector
import symmetrical.cosmic.__recycle.Absorber

class VTestEmissions {
    val ATOM1:String = "!!!!!!!!!!!!!!!"
    val CITY :String = "???????????????"


    constructor() {

    }

    fun test() : Boolean {
        if (!testEmissions()) {
            println("VTestEmissions::testEmissions FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }

    private fun testEmissions() : Boolean {
        val atom : Atom = Atom(ATOM1)
        val city : Atom = Rejector(CITY)

        val atomEmission = atom.emit()
        val (atomClone, atomRemainder) = Absorber.materialize(atomEmission)

        val cityEmission = city.emit()
        val (cityClone, cityRemainder) = Absorber.materialize(cityEmission)

        if ((cityClone as Atom).getField().toString() != city.getField().toString())
            return false

        if ((atomClone as Atom).getField().toString() != atom.getField().toString())
            return false

        return true
    }

    fun breakpoint() : Unit {
        return
    }

}