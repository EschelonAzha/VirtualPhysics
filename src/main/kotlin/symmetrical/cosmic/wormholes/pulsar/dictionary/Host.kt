package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Host(
    private val luminescent: ILuminescent = Luminescent(Host::class),
) : KeyValue(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Host::class),
    )
    constructor(key: QString, value: QString) : this() {
        add(key)
        add(value)
    }

}