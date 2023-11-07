package asymmetrical.wormholes.database.filesystem

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import java.io.File

class LineReader : Compound {
    private val lines : Compound
    constructor(fileName: QString) {
     //   lines = Compound().materialize(File(fileName.quarkSpin()).readLines()) as Compound
        lines = Compound().materialize(File(fileName.quarkSpin()).readLines()) as Compound

    }

    fun getLines() : Compound {
        return lines
    }
}