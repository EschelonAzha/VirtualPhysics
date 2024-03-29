package applications.tests.electronics

import applications.tests.dictionary.atoms.Capacitor
import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.physics.atomic.atoms.Atom
import applications.tests.dictionary.atoms.Resistor

class VTestElectronics {
    val ATOM1:String = "Atom1"
    val ATOM2:String = "Atom2"
    val ATOM3:String = "Atom3"

    val ATOM1NEW:String = "Atom1NEW"
    val ATOM3NEW:String = "Atom3NEW"


    fun test() : Boolean {

        if (!testConductors()) {
            println("VTestElectronics::testConductors FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testCapacitor()) {
            println("VTestElectronics::testCapacitor FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testDiodes()) {
            println("VTestElectronics::testDiodes FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        return true
    }
    private fun testDiodes() : Boolean {


        val atom1: Atom = Resistor().with(ATOM1)  //Resistor extends Atom and resists changes
        val atom2: Atom = Atom().with(ATOM2)
        val atom3: Atom = Atom().with(ATOM3)


        atom1.diode_(atom2).diode(atom3)  // diodes act like one-way data-binding.  Note atom1 is a resistor

        val pair1 : TauAntiTauPair = atom3.setAtomicValue(ATOM3NEW) // New value being set
        val pair2 : TauAntiTauPair = atom1.setAtomicValue(ATOM1NEW) // New value being set
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

        if (atom1Val1!="")  // Atom1 is a resistor and all changes are rejected.
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
        if (antiLepton2 != "") { // This never got a value because the first Value is a resistor
            return false
        }
        return true
    }
    private fun testConductors() : Boolean {
        val atom1: Atom = Atom().with(ATOM1)
        val atom2: Atom = Atom().with(ATOM2)
        val atom3: Atom = Atom().with(ATOM3)

        atom1.conductor_(atom2).conductor(atom3)    // Conductors are the equivalent of two-way data binding
                                                    // Diodes control electrical flow to one way flow, conductors
                                                    // can flow both directions
        val pair : TauAntiTauPair = atom1.setAtomicValue(ATOM1NEW)

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

    private fun testCapacitor() : Boolean {
        val receiver: Capacitor = Capacitor().with("Me")
        val atom    : Atom = Atom().with("Hello")

        receiver.capacitor(atom)

        atom.setAtomicValue("GoodBye")

        return true
    }
}