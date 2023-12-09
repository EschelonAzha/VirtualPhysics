package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


class Host(
    private val matter: IMatter = Matter(Host::class, Host::class),
) : KeyValue(),
    IMatter by matter
{
    constructor() : this(
        Matter(Host::class, Host::class),
    )
    constructor(key: QString, value: QString) : this() {
        add(key)
        add(value)
    }

}