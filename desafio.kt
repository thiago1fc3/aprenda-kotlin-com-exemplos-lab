// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val nivelConhecimento: Nivel) {
    fun acessarConteudo(conteudo: ConteudoEducacional) {
        println("O usuário $nome está acessando o conteúdo ${conteudo.nome}")
    }

    fun avaliarConteudo(conteudo: ConteudoEducacional, avaliacao: Int) {
        conteudo.adicionarAvaliacao(avaliacao)
        println("O usuário $nome avaliou o conteúdo ${conteudo.nome} com nota $avaliacao")
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    val avaliacoes = mutableListOf<Int>()

    fun adicionarAvaliacao(avaliacao: Int) {
        avaliacoes.add(avaliacao)
    }
}

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun listarConteudos() {
        for (conteudo in conteudos) {
            println(conteudo.nome)
        }
    }

    fun listarInscritos() {
        for (usuario in inscritos) {
            println(usuario.nome)
        }
    }

    fun obterDuracaoTotal(): Int {
        var duracaoTotal = 0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }
}

fun main() {

    val usuario1 = Usuario("João", "joao@example.com", Nivel.BASICO)
    val usuario2 = Usuario("Maria", "maria@example.com", Nivel.INTERMEDIARIO)

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    val formacao = Formacao("Formação em Ciência da Computação")
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    formacao.adicionarConteudo(conteudo3)

    // Simulação de matrícula
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Acessar e avaliar conteúdos educacionais
    usuario1.acessarConteudo(conteudo1)
    usuario1.avaliarConteudo(conteudo1, 4)

    usuario2.acessarConteudo(conteudo1)
    usuario2.avaliarConteudo(conteudo1, 5)

    // Remover conteúdo da formação
    formacao.removerConteudo(conteudo2)

    // Exibir informações
    println("Conteúdos da formação:")
    formacao.listarConteudos()

    println("Inscritos na formação:")
    formacao.listarInscritos()

    println("Duração total da formação: ${formacao.obterDuracaoTotal()} minutos")
}
