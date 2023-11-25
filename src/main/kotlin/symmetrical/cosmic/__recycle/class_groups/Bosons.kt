package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.balanced.HiggsField
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.bosons.HiggsBoson
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.WBosonMinus
import symmetrical.cosmic._physics._subatomic.matter.bosons.WBosonPlus
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson

class Bosons : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Photon::class))
        add(EntityId(Base52.classId(), WBosonMinus::class))
        add(EntityId(Base52.classId(), WBosonPlus::class))
        add(EntityId(Base52.classId(), ZBoson::class))
        add(EntityId(Base52.classId(), Graviton::class))
        add(EntityId(Base52.classId(), HiggsBoson::class))
        add(EntityId(Base52.classId(), HiggsField::class))
    }
}