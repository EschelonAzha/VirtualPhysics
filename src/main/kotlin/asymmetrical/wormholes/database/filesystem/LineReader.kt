package asymmetrical.wormholes.database.filesystem

import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.dictionary.protons.ValueProton
import java.io.File

class LineReader : Compound {
    private val lines : Compound
    constructor(fileName: QString) {
        val quark = fileName.nucleons.getProton(ValueProton::class).getValue() as Quark
  //      lines = Compound().materialize(File(quark.momentum()).readLines()) as Compound
        lines = Compound().materialize(File(momentum(quark)).readLines()) as Compound
    }
    fun getLines() : Compound {
        return lines
    }

    private fun momentum(quark:Quark) : String {
        if (spin(quark))
            return quark.getAngularMomentum().format(quark.getWavelength().getQuantumField())
        else return quark.getWavelength().toString()
    }

    private fun spin(quark:Quark) : Boolean {
        return quark.getSpin().isPlus()
    }
}