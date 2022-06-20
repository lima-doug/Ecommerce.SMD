/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smdecommerce.compras.modelo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import smdecommerce.produto.modelo.Produto;
import smdecommerce.produto.modelo.ProdutoDAO;

/**
 *
 * @author Douglas Lima
 */
public class CarrinhoCompra {

    public static final String SEPARADOR_PRODUTO = "&";
    public static final String SEPARADOR_CAMPO = "@";

    public static final String CHAVE_COOKIE_CARRINHO_COMPRA = "smdecommerce.carrinhocompras";

    /**
     *
     * Obter um objeto cookie a partir da requisição e do identificador cookie
     * do carrinho de compra
     *
     * @param request
     * @return
     */
    public static final Cookie obterCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i = 0; cookie != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals(CHAVE_COOKIE_CARRINHO_COMPRA)) {
                cookie = cookies[i];
                break;
            }
        }
        return cookie;
    }

    public static final List<CarrinhoCompraItem> obterCarrinhoCompras(String valor) {
        List<CarrinhoCompraItem> carrinhoCompraItens = new ArrayList<>();
        if (valor == null || valor.trim().length() == 0 || !valor.contains(SEPARADOR_CAMPO)) {
            return carrinhoCompraItens;
        }
        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (valor.contains(SEPARADOR_PRODUTO)) {
            String[] produtos = valor.split(SEPARADOR_PRODUTO);
            for (int i = 0; produtos != null && i < produtos.length; i++) {
                String[] item = produtos[i].split(SEPARADOR_CAMPO);
                CarrinhoCompraItem carrinhoCompraItem = new CarrinhoCompraItem();
                Produto produto = null;
                try {
                    produto = produtoDAO.obter(Integer.parseInt(item[0]));
                } catch (Exception ex) {
                    produto = null;
                }
                carrinhoCompraItem.setProduto(produto);
                carrinhoCompraItem.setQuantidade(Integer.parseInt(item[1]));
                carrinhoCompraItens.add(carrinhoCompraItem);
            }
        } else {
            String[] item = valor.split(SEPARADOR_CAMPO);
            CarrinhoCompraItem carrinhoCompraItem = new CarrinhoCompraItem();
            Produto produto = null;
            try {
                produto = produtoDAO.obter(Integer.parseInt(item[0]));
            } catch (Exception ex) {
                produto = null;
            }
            carrinhoCompraItem.setProduto(produto);
            carrinhoCompraItem.setQuantidade(Integer.parseInt(item[1]));
            carrinhoCompraItens.add(carrinhoCompraItem);
        }
        return carrinhoCompraItens;
    }

    public static final String adicionarItem(int produtoId, int quantidade, String valor) throws Exception {
        List<CarrinhoCompraItem> carrinhoCompraItens = obterCarrinhoCompras(valor);
        if (carrinhoCompraItens.isEmpty()) {
            return produtoId + SEPARADOR_CAMPO + quantidade;
        }
        boolean adicionou = false;
        String resultado = "";
        for (CarrinhoCompraItem carrinhoCompraItem : carrinhoCompraItens) {
            if (carrinhoCompraItem.getProduto().getId() == produtoId) {
                carrinhoCompraItem.setQuantidade(carrinhoCompraItem.getQuantidade() + quantidade);
                adicionou = true;
            }
            if (!resultado.isEmpty()) {
                resultado += SEPARADOR_PRODUTO;
            }
            resultado += carrinhoCompraItem.getProduto().getId() + SEPARADOR_CAMPO + carrinhoCompraItem.getQuantidade();
        }
        if (!adicionou) {
            resultado += SEPARADOR_PRODUTO + produtoId + SEPARADOR_CAMPO + quantidade;
        }
        return resultado;
    }

    public static final String removerItem(int produtoId, String valor) {
        List<CarrinhoCompraItem> carrinhoCompraItens = obterCarrinhoCompras(valor);
        if (carrinhoCompraItens.isEmpty()) {
            return "";
        }
        String resultado = "";

        for (CarrinhoCompraItem carrinhoCompraItem : carrinhoCompraItens) {
            if (carrinhoCompraItem.getProduto().getId() == produtoId) {
                continue;
            }
            if (!resultado.isEmpty()) {
                resultado += SEPARADOR_PRODUTO;
            }
            resultado += carrinhoCompraItem.getProduto().getId() + SEPARADOR_CAMPO + carrinhoCompraItem.getQuantidade();

        }
        return resultado;
    }
}
