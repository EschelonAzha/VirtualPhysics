package symmetrical.dictionary.absorber.class_groups
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.transpectors.printable_characters.Base52
import symmetrical.physics.subatomic.balanced.pairs.ElectronPositron
import symmetrical.physics.subatomic.balanced.pairs.LeptonPair
import symmetrical.physics.subatomic.matter.beta.BetaMinus
import symmetrical.physics.subatomic.matter.beta.BetaPlus
import symmetrical.physics.subatomic.matter.leptons.*
import symmetrical.physics.atomic.atoms.orbitals.Orbitals
import symmetrical.physics.subatomic.anti_matter.anti_leptons.*


class Leptons : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), AntiLepton::class))
        add(EntityId().with(Base52.classId(), AntiMuon::class))
        add(EntityId().with(Base52.classId(), AntiMuonNeutrino::class))
        add(EntityId().with(Base52.classId(), AntiNeutrino::class))
        add(EntityId().with(Base52.classId(), AntiTau::class))
        add(EntityId().with(Base52.classId(), AntiTauNeutrino::class))
        add(EntityId().with(Base52.classId(), BetaMinus::class))
        add(EntityId().with(Base52.classId(), BetaPlus::class))
        add(EntityId().with(Base52.classId(), Electron::class))
        add(EntityId().with(Base52.classId(), ElectronPositron::class))
        add(EntityId().with(Base52.classId(), Lepton::class))
        add(EntityId().with(Base52.classId(), LeptonPair::class))
        add(EntityId().with(Base52.classId(), Muon::class))
        add(EntityId().with(Base52.classId(), MuonNeutrino::class))
        add(EntityId().with(Base52.classId(), Neutrino::class))
        add(EntityId().with(Base52.classId(), Orbitals::class))
        add(EntityId().with(Base52.classId(), Tau::class))
        add(EntityId().with(Base52.classId(), TauNeutrino::class))
    }
}