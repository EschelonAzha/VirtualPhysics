package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.*
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.Kaon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.MinusPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralDownPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics._subatomic.matter.quarks.*


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