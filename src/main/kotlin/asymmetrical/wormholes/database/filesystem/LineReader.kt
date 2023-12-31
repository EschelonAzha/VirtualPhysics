package asymmetrical.wormholes.database.filesystem

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.dictionary.protons.ValueProton
import java.io.File

class LineReader : Compound {
    private val lines : Compound
    constructor(fileName: QString) {
        val proton: Proton = fileName.getProton(ValueProton::class)
        val quark : Quark  = proton.getValueQuark()
        lines = Compound().materialize(File(Wavelength.format(fileName).toString()).readLines()) as Compound
    }
    fun getLines() : Compound {
        return lines
    }
}