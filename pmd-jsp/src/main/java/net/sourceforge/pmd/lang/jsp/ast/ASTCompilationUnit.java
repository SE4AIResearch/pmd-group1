/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.lang.ast.AstInfo;
import net.sourceforge.pmd.lang.ast.Parser.ParserTask;
import net.sourceforge.pmd.lang.ast.RootNode;

public final class ASTCompilationUnit extends AbstractJspNode implements RootNode {

    private AstInfo<ASTCompilationUnit> astInfo;

    ASTCompilationUnit(int id) {
        super(id);
    }

    @Override
    public AstInfo<ASTCompilationUnit> getAstInfo() {
        return astInfo;
    }

    AstInfo<ASTCompilationUnit> makeTaskInfo(ParserTask task) {
        this.astInfo = new AstInfo<>(task, this);
        return astInfo;
    }

    @Override
    protected <P, R> R acceptVisitor(JspVisitor<? super P, ? extends R> visitor, P data) {
        return visitor.visit(this, data);
    }
}
