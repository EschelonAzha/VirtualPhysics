package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.*
import symmetrical.cosmic._physics._subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaMinus
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaPlus
import symmetrical.cosmic._physics._subatomic.matter.leptons.*
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals

class Leptons : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AntiLepton::class))
        add(EntityId(Base52.classId(), AntiMuon::class))
        add(EntityId(Base52.classId(), AntiMuonNeutrino::class))
        add(EntityId(Base52.classId(), AntiNeutrino::class))
        add(EntityId(Base52.classId(), AntiTau::class))
        add(EntityId(Base52.classId(), AntiTauNeutrino::class))
        add(EntityId(Base52.classId(), BetaMinus::class))
        add(EntityId(Base52.classId(), BetaPlus::class))
        add(EntityId(Base52.classId(), Electron::class))
        add(EntityId(Base52.classId(), ElectronPositron::class))
        add(EntityId(Base52.classId(), Lepton::class))
        add(EntityId(Base52.classId(), LeptonPair::class))
        add(EntityId(Base52.classId(), Muon::class))
        add(EntityId(Base52.classId(), MuonNeutrino::class))
        add(EntityId(Base52.classId(), Neutrino::class))
        add(EntityId(Base52.classId(), Orbitals::class))
        add(EntityId(Base52.classId(), Tau::class))
        add(EntityId(Base52.classId(), TauNeutrino::class))



    }
}