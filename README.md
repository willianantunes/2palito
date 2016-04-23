Portal Web e App Android **2 Palito**
===========

Este trabalho trata do estudo de viabilidade t�cnica com a implementa��o de um prot�tipo funcional referente a um sistema para dispositivos m�veis cuja finalidade � disponibilizar digitalmente a oferta de produtos de restaurantes em shoppings para que seus clientes possam consult�-los, por meio de um smartphone, e ent�o realizar seus pedidos. O prot�tipo contempla um subsistema baseado em uma aplica��o web para que os lojistas possam manter seus cadastros atualizados, terem acesso a consultas estat�sticas de visita��o, realizem controle de todos seus produtos, ofere�am promo��es aos clientes e por fim at� realizar a intera��o com clientes afim de atend�-los atrav�s do portal.

As duas solu��es s�o um resultado do estudo de viabilidade t�cnica feito para a *[Fatec Ipiranga](http://www.fatecipiranga.edu.br/)*.

## Prop�sito final

Eliminar filas para realiza��o de pedidos.

## Requisitos e detalhes t�cnicos

- O portal web utiliza o framework VRaptor 3.5.3 para invers�o de controle e inje��o de depend�ncia. Durante o desenvolvimento foram usados o Apache Tomcat 7 e o MySQL (vers�o simplificada dispon�vel no XAMPP).
- Como o portal web mant�m todo o controle de produtos e disponibiliza web services REST para consult�-los, o App Android faz todas as consultas com aux�lio do framework [Spring Android](http://projects.spring.io/spring-android/).
- O App para dispositivo m�vel suporta a vers�o 4.x.x (a princ�pio) do Android.

## Melhorias

- Atualizar Portal Web para utiliza��o do VRaptor 4 e AngulasJS; 
- Passar estrutura do web service REST para o Apache Camel;
- Atualizar App para Android para a �ltima vers�o do sistema operacional;

## Equipe de desenvolvimento

[Bruno Alves](https://github.com/brunoooalves)
[Wellington Almeida](https://github.com/wpgalmeida)
[Willian Antunes](http://willianantunes.blogspot.com.br/)