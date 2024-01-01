package websites.tests

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom

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
        val atom1: Atom = Atom(ATOM1)
        val atom2: Atom = Atom(ATOM2)
        val atom3: Atom = Atom(ATOM3)

        atom1.diode_(atom2).diode(atom3)

        val pair1 : TauAntiTauPair = atom3.setCurrentValue(ATOM3NEW)
        val pair2 : TauAntiTauPair = atom1.setCurrentValue(ATOM1NEW)

        val atom1Val1 = atom1.getField().toString()
        val atom2Val1 = atom2.getField().toString()
        val atom3Val1 = atom3.getField().toString()

        if (atom1Val1!=ATOM1NEW)
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
        if (antiLepton2 != ATOM3NEW) {
            return false
        }
        return true
    }
    private fun testConductors() : Boolean {
        val atom1: Atom = Atom(ATOM1)
        val atom2: Atom = Atom(ATOM2)
        val atom3: Atom = Atom(ATOM3)

        atom1.conductor_(atom2).conductor(atom3)

        val pair : TauAntiTauPair = atom1.setCurrentValue(ATOM1NEW)

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