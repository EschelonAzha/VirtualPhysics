package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.Kaon
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.MinusPion
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.NeutralDownPion
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic.physics.subatomic.matter.quarks.*
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.*


class Quarks : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AntiBottom::class))
        add(EntityId(Base52.classId(), AntiCharm::class))
        add(EntityId(Base52.classId(), AntiDown::class))
        add(EntityId(Base52.classId(), AntiQuark::class))
        add(EntityId(Base52.classId(), AntiStrange::class))
        add(EntityId(Base52.classId(), AntiTop::class))
        add(EntityId(Base52.classId(), AntiUp::class))
        add(EntityId(Base52.classId(), Bottom::class))
        add(EntityId(Base52.classId(), Charm::class))
        add(EntityId(Base52.classId(), Down::class))
        add(EntityId(Base52.classId(), Kaon::class))
        add(EntityId(Base52.classId(), MinusPion::class))
        add(EntityId(Base52.classId(), NeutralDownPion::class))
        add(EntityId(Base52.classId(), NeutralUpPion::class))
        add(EntityId(Base52.classId(), Quark::class))
        add(EntityId(Base52.classId(), Strange::class))
        add(EntityId(Base52.classId(), Top::class))
        add(EntityId(Base52.classId(), Up::class))
    }
}