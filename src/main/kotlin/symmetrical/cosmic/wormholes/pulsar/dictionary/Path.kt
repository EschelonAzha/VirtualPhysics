package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Path(
    private val luminescent: ILuminescent = Luminescent(Path::class),
) : Molecule(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Path::class),
    )
    init {
        parsePath("")
    }
    constructor(value:String) : this() {
        parsePath(value)
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