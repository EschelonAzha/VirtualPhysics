package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._creation.BigBang
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity
import symmetrical.cosmic._physics.atomic.blackhole.Blackhole
import symmetrical.cosmic._physics.atomic.blackhole.EventHorizon

class Cosmic : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), BigBang::class))
        add(EntityId(Base52.classId(), Blackhole::class))
        add(EntityId(Base52.classId(), EventHorizon::class))
        add(EntityId(Base52.classId(), Gravity::class))
        add(EntityId(Base52.classId(), Universe::class))


    }
}