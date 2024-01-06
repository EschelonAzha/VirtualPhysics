package applications.tests


import applications.tests.dictionary.AddressRow
import symmetrical.cosmic.physics.atomic.atoms.Atom

class VTestNeutrons {
    val ATOM1: String = "!!!!!!!!!!!!!!!"
    val NEXT : String = "???????????????"


    constructor() {

    }

    fun test(): Boolean {
        if (!testNeutrons()) {
            println("VTestNeutrons::testNeutrons FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        if (!testMoleculeRollback()) {
            println("VTestNeutrons::testMoleculeRollback FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }

    private fun testNeutrons(): Boolean {
        val atom: Atom = Atom(ATOM1)

        val original : String = atom.getField().toString()

        atom.betaPlusDecay("NewStuff")

        val afterDecay : String = atom.getField().toString()

        atom.betaMinusDecay()

        val restored : String = atom.getField().toString()

        if (restored != original)
            return false

        return true
    }

    private fun testMoleculeRollback() : Boolean {
        val row: AddressRow = AddressRow()
        row.betaPlusDecay()
        row.print()


        row.name.setContent("Name2")
        row.address.setContent("address2")
        row.city.setContent("city2")
        row.state.setContent("state2")
        row.print()

        row.betaMinusDecay()
        row.print()


        return true
    }

    fun breakpoint(): Unit {
        return
    }
}
