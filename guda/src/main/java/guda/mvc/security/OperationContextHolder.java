/**
 * zoneland.net Inc.
 * Copyright (c) 2002-2012 All Rights Reserved.
 */
package guda.mvc.security;

/**
 * 操作以及用户信息上下�?存放当前登录用户的用户名，用户ID，用户角色等相关信息�?br>
 * 应用程序中�?�?pre>OperationContextHolder.getPrincipal()</pre>或�?<br>
 * <pre>OperationContextHolder.getOperationContext()</pre>获取当前登录用户�?br>
 * 相关信息<br>
 * <p>
 * 存放在threadlocal中，线程安全�?br>
 * </p>
 * @author gag
 * @version $Id: OperatorContextHolder.java, v 0.1 2012-5-21 下午1:19:57 gag Exp $
 */
public class OperationContextHolder {

    /** 当前操作上下�?*/
    private static OperationContext anonymousOperationContext;

    /** 匿名用户的用户名 */
    public static final String      ANONYMOUS_USER = "anonymous";

    /**
     * 获取当前操作上下�?
     * @return OperationContext当前上下文，包括用户基本属�?，角色等相关信息
     */
    public static OperationContext getOperationContext() {
        OperationContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return newAnonymousOperationContext();
        }
        return context;
    }

    public static void setOperationContext(OperationContext context) {
        SecurityContextHolder.setContext(context);
    }

    public static void setOperationRole(OperationRole[] operationRoles) {
        getOperationContext().setAuthorities(operationRoles);
    }

    public static void setPrincipal(OperationPrincipal operationPrincipal) {
        getOperationContext().setPrincipal(operationPrincipal);
    }

    public static OperationPrincipal getPrincipal() {
        return getOperationContext().getPrincipal();
    }

    protected static OperationContext newAnonymousOperationContext() {
        if (anonymousOperationContext == null) {
            OperationPrincipal principal = new OperationPrincipal();
            principal.setUserId(ANONYMOUS_USER);
            principal.setLogonId(ANONYMOUS_USER);
            OperationRole[] authorities = new OperationRole[] {};
            OperationContext operationContext = new OperationContext(principal, authorities);
            anonymousOperationContext = operationContext;
            return operationContext;
        } else {
            return anonymousOperationContext;
        }
    }

    public static void createOperationContext(String userId, String provinceId) {
        OperationPrincipal principal = new OperationPrincipal();
        principal.setUserId(userId);
        principal.setProvinceId(provinceId);
        OperationRole[] authorities = new OperationRole[] {};
        OperationContext operationContext = new OperationContext(principal, authorities);
        OperationContextHolder.setOperationContext(operationContext);
    }
}
