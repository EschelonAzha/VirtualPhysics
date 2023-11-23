package symmetrical.cosmic.__recycle

import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic.__transpectors.printable_characters.*
import symmetrical.cosmic._bitmaps.*
import symmetrical.cosmic._physics._creation.BigBang
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._dimensions.time.Strobe
import symmetrical.cosmic._physics._dimensions.time.Time
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.*
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.*
import symmetrical.cosmic._physics._subatomic.balanced.HiggsField
import symmetrical.cosmic._physics._subatomic.balanced.Monad
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharges
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.balanced.quarks.QuarkValue
import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.bosons.Higgs
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.forces.strong_force.Strong
import symmetrical.cosmic._physics._subatomic.forces.weak_force.Charge
import symmetrical.cosmic._physics._subatomic.forces.weak_force.ChargedWeak
import symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral.ChargedWeakForce
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaMinus
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaPlus
import symmetrical.cosmic._physics._subatomic.matter.bosons.WBosonMinus
import symmetrical.cosmic._physics._subatomic.matter.bosons.WBosonPlus
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.matter.colors.manifestations.CRLFTerminatedColor
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.Kaon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.MinusPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralDownPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.*
import symmetrical.cosmic._physics._subatomic.matter.quarks.*
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.Composition
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.elements.Helium
import symmetrical.cosmic._physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics.atomic.atoms.states.booleans.QBoolean
import symmetrical.cosmic._physics.atomic.atoms.states.bytes.QByte
import symmetrical.cosmic._physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic._physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString
import symmetrical.cosmic._physics.atomic.atoms.states.vectors.QMass
import symmetrical.cosmic._physics.atomic.blackhole.Blackhole
import symmetrical.cosmic._physics.atomic.blackhole.EventHorizon
import symmetrical.cosmic._physics.atomic.bonds.alloys.Alloy
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Mixture
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Solution
import symmetrical.cosmic._physics.atomic.matter.Material
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics.atomic.substance.ions.Anion
import symmetrical.cosmic._physics.atomic.substance.ions.Cation
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics.atomic.substance.ions.Ion
import symmetrical.cosmic._physics.atomic.substance.metals.Metal
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.dictionary.PasswordFld
import symmetrical.cosmic.dictionary.UseridFld
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.wormholes.messaging.login.AppendMSG
import symmetrical.cosmic.wormholes.messaging.login.LoginMSG
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG
import symmetrical.cosmic.wormholes.pulsar.dictionary.Host
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path
import symmetrical.cosmic.wormholes.pulsar.socket.Outlet
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage
import symmetrical.device.DeviceInput
import symmetrical.dom.Dom
import symmetrical.dom.DomProperties
import symmetrical.dom.DomProperty
import symmetrical.dom.dom.Body
import symmetrical.dom.properties.colors.BackgroundColor
import symmetrical.dom.properties.identification.DomId
import symmetrical.dom.properties.region.DomHeight
import symmetrical.dom.properties.region.DomLeft
import symmetrical.dom.properties.region.DomTop
import symmetrical.dom.properties.region.DomWidth
import symmetrical.dom.properties.style.DomStyle

class ClassGroup : Beam {
    constructor() : super(500) {
        add(EntityId(Base52.classId(), Alloy::class))
        add(EntityId(Base52.classId(), AngularMomentum::class))
        add(EntityId(Base52.classId(), Anion::class))
        add(EntityId(Base52.classId(), AntiColor::class))
        add(EntityId(Base52.classId(), AntiBlue::class))
        add(EntityId(Base52.classId(), AntiBottom::class))
        add(EntityId(Base52.classId(), AntiCharm::class))
        add(EntityId(Base52.classId(), AntiDown::class))
        add(EntityId(Base52.classId(), AntiGreen::class))
        add(EntityId(Base52.classId(), AntiLepton::class))
        add(EntityId(Base52.classId(), AntiMuon::class))
        add(EntityId(Base52.classId(), AntiMuonNeutrino::class))
        add(EntityId(Base52.classId(), AntiNeutrino::class))
        add(EntityId(Base52.classId(), AntiQuark::class))
        add(EntityId(Base52.classId(), AntiRed::class))
        add(EntityId(Base52.classId(), AntiStrange::class))
        add(EntityId(Base52.classId(), AntiTau::class))
        add(EntityId(Base52.classId(), AntiTauNeutrino::class))
        add(EntityId(Base52.classId(), AntiTop::class))
        add(EntityId(Base52.classId(), AntiUp::class))
        add(EntityId(Base52.classId(), Atom::class))
        add(EntityId(Base52.classId(), Baryon::class))
        add(EntityId(Base52.classId(), Base52::class))
        add(EntityId(Base52.classId(), Beam::class))
        add(EntityId(Base52.classId(), BetaMinus::class))
        add(EntityId(Base52.classId(), BetaPlus::class))
        add(EntityId(Base52.classId(), BigBang::class))
        add(EntityId(Base52.classId(), Bits04::class))
        add(EntityId(Base52.classId(), Bits08::class))
        add(EntityId(Base52.classId(), Bits16::class))
        add(EntityId(Base52.classId(), Bits24::class))
        add(EntityId(Base52.classId(), Bits32::class))
        add(EntityId(Base52.classId(), Bits64::class))
        add(EntityId(Base52.classId(), Blackhole::class))
        add(EntityId(Base52.classId(), Blue::class))
        add(EntityId(Base52.classId(), Blue_AntiBlue::class))
        add(EntityId(Base52.classId(), Blue_AntiGreen::class))
        add(EntityId(Base52.classId(), Blue_AntiRed::class))
        add(EntityId(Base52.classId(), Bottom::class))
        add(EntityId(Base52.classId(), Cation::class))
        add(EntityId(Base52.classId(), Characters::class))
        add(EntityId(Base52.classId(), Charge::class))
        add(EntityId(Base52.classId(), ChargedWeak::class))
        add(EntityId(Base52.classId(), ChargedWeakForce::class))
        add(EntityId(Base52.classId(), Charm::class))
        add(EntityId(Base52.classId(), ChromoCharge::class))
        add(EntityId(Base52.classId(), Color::class))
        add(EntityId(Base52.classId(), ColorCharges::class))
        add(EntityId(Base52.classId(), Composition::class))
        add(EntityId(Base52.classId(), Compound::class))
        add(EntityId(Base52.classId(), CRLFTerminatedColor::class))
        add(EntityId(Base52.classId(), CRLFTerminatedMomentum::class))
        add(EntityId(Base52.classId(), CrLfTerminatedString::class))
        add(EntityId(Base52.classId(), DeviceInput::class))
        add(EntityId(Base52.classId(), Diatomic::class))
        add(EntityId(Base52.classId(), Down::class))
        add(EntityId(Base52.classId(), Electron::class))
        add(EntityId(Base52.classId(), ElectronPositron::class))
        add(EntityId(Base52.classId(), EventHorizon::class))
        add(EntityId(Base52.classId(), Fundamentals::class))
        add(EntityId(Base52.classId(), Gluon::class))
        add(EntityId(Base52.classId(), Graviton::class))
        add(EntityId(Base52.classId(), Gravity::class))
        add(EntityId(Base52.classId(), Green::class))
        add(EntityId(Base52.classId(), Green_AntiBlue::class))
        add(EntityId(Base52.classId(), Green_AntiGreen::class))
        add(EntityId(Base52.classId(), Green_AntiRed::class))
        add(EntityId(Base52.classId(), Hadron::class))
        add(EntityId(Base52.classId(), Helium::class))
        add(EntityId(Base52.classId(), Host::class))
        add(EntityId(Base52.classId(), Hydrogen::class))
        add(EntityId(Base52.classId(), HiggsField::class))
        add(EntityId(Base52.classId(), Higgs::class))
        add(EntityId(Base52.classId(), Ion::class))
        add(EntityId(Base52.classId(), Kaon::class))
        add(EntityId(Base52.classId(), KeyValue::class))
        add(EntityId(Base52.classId(), Lepton::class))
        add(EntityId(Base52.classId(), LeptonPair::class))
        add(EntityId(Base52.classId(), LowerCase::class))
        add(EntityId(Base52.classId(), Magnetism::class))
        add(EntityId(Base52.classId(), Material::class))
        add(EntityId(Base52.classId(), Matter::class))
        add(EntityId(Base52.classId(), Message::class))
        add(EntityId(Base52.classId(), Metal::class))
        add(EntityId(Base52.classId(), MinusPion::class))
        add(EntityId(Base52.classId(), Mixture::class))
        add(EntityId(Base52.classId(), Molecular::class))
        add(EntityId(Base52.classId(), Molecule::class))
        add(EntityId(Base52.classId(), Monad::class))
        add(EntityId(Base52.classId(), Muon::class))
        add(EntityId(Base52.classId(), MuonNeutrino::class))
        add(EntityId(Base52.classId(), Neutrino::class))
        add(EntityId(Base52.classId(), Neutron::class))
        add(EntityId(Base52.classId(), Neutrons::class))
        add(EntityId(Base52.classId(), NeutralDownPion::class))
        add(EntityId(Base52.classId(), NeutralUpPion::class))
        add(EntityId(Base52.classId(), Nucleons::class))
        add(EntityId(Base52.classId(), Numbers::class))
        add(EntityId(Base52.classId(), Orbitals::class))
        add(EntityId(Base52.classId(), Outlet::class))
        add(EntityId(Base52.classId(), Particle::class))
        add(EntityId(Base52.classId(), ParticleBeam::class))
        add(EntityId(Base52.classId(), PasswordFld::class))
        add(EntityId(Base52.classId(), Path::class))
        add(EntityId(Base52.classId(), Photon::class))
        add(EntityId(Base52.classId(), Proton::class))
        add(EntityId(Base52.classId(), Protons::class))
        add(EntityId(Base52.classId(), QuarkValue::class))
        add(EntityId(Base52.classId(), QBoolean::class))
        add(EntityId(Base52.classId(), QByte::class))
        add(EntityId(Base52.classId(), QCD::class))
        add(EntityId(Base52.classId(), QDouble::class))
        add(EntityId(Base52.classId(), QInt::class))
        add(EntityId(Base52.classId(), QString::class))
        add(EntityId(Base52.classId(), QMass::class))
        add(EntityId(Base52.classId(), Quark::class))
        add(EntityId(Base52.classId(), Red::class))
        add(EntityId(Base52.classId(), Red_AntiBlue::class))
        add(EntityId(Base52.classId(), Red_AntiBlue::class))
        add(EntityId(Base52.classId(), Red_AntiRed::class))
        add(EntityId(Base52.classId(), SocketMessage::class))
        add(EntityId(Base52.classId(), Solution::class))
        add(EntityId(Base52.classId(), Spin::class))
        add(EntityId(Base52.classId(), Strange::class))
        add(EntityId(Base52.classId(), Strobe::class))
        add(EntityId(Base52.classId(), Strong::class))
        add(EntityId(Base52.classId(), Tau::class))
        add(EntityId(Base52.classId(), TauNeutrino::class))
        add(EntityId(Base52.classId(), Time::class))
        add(EntityId(Base52.classId(), Top::class))
        add(EntityId(Base52.classId(), Universe::class))
        add(EntityId(Base52.classId(), Up::class))
        add(EntityId(Base52.classId(), UpperCase::class))
        add(EntityId(Base52.classId(), UseridFld::class))
        add(EntityId(Base52.classId(), Wavelength::class))
        add(EntityId(Base52.classId(), WBosonMinus::class))
        add(EntityId(Base52.classId(), WBosonPlus::class))
        add(EntityId(Base52.classId(), ZBoson::class))
        /************************/
        add(EntityId(Base52.classId(), AppendMSG::class))
        add(EntityId(Base52.classId(), BackgroundColor::class))
        add(EntityId(Base52.classId(), Body::class))
        add(EntityId(Base52.classId(), Dom::class))
        add(EntityId(Base52.classId(), DomHeight::class))
        add(EntityId(Base52.classId(), DomId::class))
        add(EntityId(Base52.classId(), DomLeft::class))
        add(EntityId(Base52.classId(), DomStyle::class))
        add(EntityId(Base52.classId(), DomTop::class))
        add(EntityId(Base52.classId(), DomWidth::class))
        add(EntityId(Base52.classId(), DomProperties::class))
        add(EntityId(Base52.classId(), DomProperty::class))
        add(EntityId(Base52.classId(), HtmlPeer::class))
        add(EntityId(Base52.classId(), LoginMSG::class))
        add(EntityId(Base52.classId(), ReadyMSG::class))

        print()
    }
    
}