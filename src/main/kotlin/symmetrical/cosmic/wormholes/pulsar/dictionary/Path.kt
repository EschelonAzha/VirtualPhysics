package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


class Path(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Molecule(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )
    init {
        parsePath("")
    }
    constructor(value:String) : this(QuantumEntanglement()) {
        parsePath(value)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Path::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    private fun parsePath(value:String) : Path {
        var tokens = value.split("/")
        for (i in 1 until tokens.size) {
            if (tokens[i]!= "")
                add(QString(tokens[i]))
        }
        shrink()
        return this
    }
}