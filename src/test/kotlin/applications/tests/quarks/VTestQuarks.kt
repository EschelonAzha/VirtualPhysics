package applications.tests.quarks

import applications.tests.dictionary.atoms.BookTitle
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.physics.subatomic.matter.leptons.Tau

class VTestQuarks {
    val ATOM1:String = "Atom1"


    fun test() : Boolean {

        if (!testFormat()) {
            println("VTestQuarks::testFormat FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        if (!testConstraints()) {
            println("VTestQuarks::testConstraints FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }
    private fun testFormat() : Boolean {
        val atom:Atom = BookTitle().with("Dolphins Prefer Kotlin")

        val quoted = atom.format()

        if (!quoted.startsWith("\""))
            return false
        if (!quoted.endsWith("\""))
            return false
        return true
    }
    private fun testConstraints() : Boolean {
        val atom:Atom = BookTitle().with("Dolphins Prefer Kotlin")

        val result: TauAntiTauPair = atom.setAtomicValue("How to Know you are always right, without being wrong")

        val reason = result.getReason()
        val code = result.getReasonCode()
        val accepted = result.isAccepted()

        if (code != -3) {
            return false
        }
        if (accepted) {
            return false
        }
        if (reason != "Value must not exceed: 25 characters.")
            return false

        return true
    }
}