package applications.tests.electronics

import symmetrical.cosmic.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic.physics.atomic.atoms.Atom
import applications.tests.dictionary.atoms.Resistor

class VTestElectronics {
    val ATOM1:String = "Atom1"
    val ATOM2:String = "Atom2"
    val ATOM3:String = "Atom3"

    val ATOM1NEW:String = "Atom1NEW"
    val ATOM3NEW:String = "Atom3NEW"


    constructor() {

    }

    fun test() : Boolean {
        if (!testDiodes()) {
            println("VTestElectronics::testDiodes FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testConductors()) {
            println("VTestElectronics::testConductors FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }
    private fun testDiodes() : Boolean {


        val atom1: Atom = Resistor(ATOM1)  //Resistor extends Atom and resists changes
        val atom2: Atom = Atom(ATOM2)
        val atom3: Atom = Atom(ATOM3)

        atom1.diode_(atom2).diode(atom3)  // diodes act like one-way data-binding.  Note atom1 is a resistor

        val pair1 : TauAntiTauPair = atom3.setContent(ATOM3NEW) // New value being set
        val pair2 : TauAntiTauPair = atom1.setContent(ATOM1NEW) // New value being set
                                                                // Tau contains the new Value
                                                                // AntiTau contains previous value
                                                                // TauAntiTauPair returns success/fail and
                                                                // reason for rejection if fail

        val accepted    : Boolean    = pair2.isAccepted()       // check if value change is accepted
        val reason      : String     = pair2.getReason()        // get reason if failed
        val reasonCode  : Int        = pair2.getReasonCode()    // get reason code

        if (accepted)
            return false
        if (reasonCode != 20)
            return false
        if (reason != "Nope!")
            return false

        val atom1Val1 = atom1.getField().toString()
        val atom2Val1 = atom2.getField().toString()
        val atom3Val1 = atom3.getField().toString()

        if (atom1Val1!=ATOM1)
            return false
        if (atom2Val1!=ATOM3NEW)
            return false
        if (atom3Val1!=ATOM3NEW)
            return false

        val lepton1     : String    = pair1.getField().toString()
        val antiLepton1 : String    = pair1.getAntiField().toString()

        val lepton2     : String    = pair2.getField().toString()
        val antiLepton2 : String    = pair2.getAntiField().toString()

        if (lepton1 != ATOM3NEW){
            return false
        }
        if (lepton2 != ATOM1NEW) {
            return false
        }
        if (antiLepton1 != ATOM3){
            return false
        }
        if (antiLepton2 != ATOM1) {
            return false
        }
        return true
    }
    private fun testConductors() : Boolean {
        val atom1: Atom = Atom(ATOM1)
        val atom2: Atom = Atom(ATOM2)
        val atom3: Atom = Atom(ATOM3)

        atom1.conductor_(atom2).conductor(atom3)    // Conductors are the equivalent of two-way data binding
                                                    // Diodes control electrical flow to one way flow, conductors
                                                    // can flow both directions
        val pair : TauAntiTauPair = atom1.setContent(ATOM1NEW)

        val atom1Val1 = atom1.getField().toString()
        val atom2Val1 = atom2.getField().toString()
        val atom3Val1 = atom3.getField().toString()

        if (atom1Val1!=ATOM1NEW)
            return false
        if (atom2Val1!=ATOM1NEW)
            return false
        if (atom3Val1!=ATOM1NEW)
            return false


        val lepton     : String    = pair.getField().toString()
        val antiLepton : String    = pair.getAntiField().toString()

        if (lepton != ATOM1NEW){
            return false
        }
        if (antiLepton != ATOM1) {
            return false
        }

        return true
    }
}