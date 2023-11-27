package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Host(
    private val antiMatter: IAntiMatter = AntiMatter(Host::class),
) : KeyValue(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Host::class),
    )
    constructor(key: QString, value: QString) : this() {
        add(key)
        add(value)
    }

}