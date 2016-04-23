Portal Web e App Android **2 Palito**
===========

Este trabalho trata do estudo de viabilidade técnica com a implementação de um protótipo funcional referente a um sistema para dispositivos móveis cuja finalidade é disponibilizar digitalmente a oferta de produtos de restaurantes em shoppings para que seus clientes possam consultá-los, por meio de um smartphone, e então realizar seus pedidos. O protótipo contempla um subsistema baseado em uma aplicação web para que os lojistas possam manter seus cadastros atualizados, terem acesso a consultas estatísticas de visitação, realizem controle de todos seus produtos, ofereçam promoções aos clientes e por fim até realizar a interação com clientes afim de atendê-los através do portal.

As duas soluções são um resultado do estudo de viabilidade técnica feito para a *[Fatec Ipiranga](http://www.fatecipiranga.edu.br/)*.

## Propósito final

Eliminar filas para realização de pedidos.

## Requisitos e detalhes técnicos

- O portal web utiliza o framework VRaptor 3.5.3 para inversão de controle e injeção de dependência. Durante o desenvolvimento foram usados o Apache Tomcat 7 e o MySQL (versão simplificada disponível no XAMPP).
- Como o portal web mantém todo o controle de produtos e disponibiliza web services REST para consultá-los, o App Android faz todas as consultas com auxílio do framework [Spring Android](http://projects.spring.io/spring-android/).
- O App para dispositivo móvel suporta a versão 4.x.x (a princípio) do Android.

## Melhorias

- Atualizar Portal Web para utilização do VRaptor 4 e AngulasJS; 
- Passar estrutura do web service REST para o Apache Camel;
- Atualizar App para Android para a última versão do sistema operacional;

## Equipe de desenvolvimento

[Bruno Alves](https://github.com/brunoooalves)
[Wellington Almeida](https://github.com/wpgalmeida)
[Willian Antunes](http://willianantunes.blogspot.com.br/)