package applications.tests.nuclear


import applications.tests.dictionary.composites.AddressRow
import symmetrical.physics.atomic.atoms.Atom

class VTestNeutrons {
    val ATOM1: String = "!!!!!!!!!!!!!!!"
    val NEXT : String = "???????????????"


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
        val atom: Atom = Atom().with(ATOM1)

        val original : String = atom.getField().toString()

                                                // beta decay converts protons into Neutrons creating new Isotopes that
                                                // that are chemically equivalent.

        atom.betaPlusDecay("NewStuff")  // The current proton value is stored in a Neutron creating a heavier Isotope

        val afterDecay : String = atom.getField().toString() // after decay the new value contains "NewStuff"

        atom.betaMinusDecay()  // convert Neutron back into Proton and restore original values.
                                // particles derived from Atoms are capable of creating new Isotopes of themselves
                                // and have the ability to do rollbacks.   All Atoms and Molecules have the ability
                                // to change and rollback at an atomic level.
                                // They also have the ability to emit and absorb themselves over a distance (network)
                                // and can use electron flows to do one and two-way data binding via diodes/conductors
                                // and capacitors.

        val restored : String = atom.getField().toString()

        if (restored != original)
            return false

        return true
    }

    private fun testMoleculeRollback() : Boolean {
        val row: AddressRow = AddressRow().with("name", "address", "city", "state")
        row.betaPlusDecay()     // whole records (Molecules and Compounds) can convert all their Atoms into Isotopes
        row.print()


        row.getName().setContent("Name2")
        row.getAddress().setContent("address2")
        row.getCity().setContent("city2")
        row.getState().setContent("state2")
        row.print()

        row.betaMinusDecay()    // and can be rolled back as a complete record by decaying their neutrons and restoring
                                // their original Proton values.
        row.print()


        return true
    }

}
