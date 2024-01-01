package websites.tests

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom


object XTestWindUnwind  {
    // run main then
    // localhost:8081/FabricFlowNode
    @JvmStatic
    fun main(args: Array<String>) {
        test();
    }

    private fun test() {

        val atom: Atom = Atom()
        Quark.value(atom).setWavelength(200)
        atom.wind("")
        Quark.value(atom).setWavelength(300)



        return



    }
}