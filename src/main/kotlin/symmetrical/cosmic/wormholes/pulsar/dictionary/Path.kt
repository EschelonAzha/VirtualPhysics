package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Path(
    private val antiMatter: IAntiMatter = AntiMatter(Path::class),
) : Molecule(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Path::class),
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