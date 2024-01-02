package applications.tests


import symmetrical.cosmic._physics.atomic.atoms.Atom

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

    fun breakpoint(): Unit {
        return
    }
}
